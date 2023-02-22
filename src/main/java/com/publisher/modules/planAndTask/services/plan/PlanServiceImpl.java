package com.publisher.modules.planAndTask.services.plan;

import com.publisher.modules.planAndTask.dtos.plan.PlanCreateDTO;
import com.publisher.modules.planAndTask.dtos.plan.PlanReadDTO;
import com.publisher.modules.planAndTask.dtos.plan.PlanUpdateDTO;
import com.publisher.modules.planAndTask.dtos.planLog.PlanLogCreateDTO;
import com.publisher.modules.planAndTask.entities.Plan;
import com.publisher.modules.planAndTask.entities.PlanLog;
import com.publisher.modules.planAndTask.repositories.PlanRepository;
import com.publisher.modules.planAndTask.services.planLog.PlanLogService;
import com.publisher.utils.enums.LogReason;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private PlanLogService planLogService;



    /* CREATE */
    @Override
    public Plan createPlan(Plan plan) throws Exception {
        /* Validate input */
        if (plan.getPlanStart().after(plan.getPlanEnd())) {/* Check date */
            throw new IllegalArgumentException(
                    "StartDate cannot be after EndDate. Create Aborted."); }

        /* Check duplicate */
        if (planRepository.isDuplicateInsert(plan.getPlanCode())) {
            throw new IllegalArgumentException(
                    "Duplication found when creating Plan. Create Aborted."); }
        
        /* Create Plan */
        plan = planRepository.saveAndFlush(plan);
        
        /* Create Log */
        try {
            PlanLog firstLog = mapper.map(plan, PlanLog.class);
            firstLog.setPlan(plan); /* TODO: remove this, to save on space */
            firstLog.setLogReason(LogReason.CREATE.stringValue);
            
            planLogService.createPlanLog(firstLog);
        } catch (Exception e) {
            planRepository.deleteById(plan.getPlanId());
            throw new RuntimeException(
                    "Plan Created. But error for creating 1st Log for Plan with code: " + plan.getPlanCode() +
                            ". Creation reversed.");
        }

        return plan;
    }
    @Override
    public PlanReadDTO createPlanByDTO(PlanCreateDTO planDTO) throws Exception {
        Plan plan = mapper.map(planDTO, Plan.class);

        plan = createPlan(plan);

        return dtoWrapperSingle(plan);
    }

    /* READ */
    @Override
    public boolean existsById(int planId) throws Exception {
        return planRepository.existsById(planId);
    }
    @Override
    public Plan getById(int planId) throws Exception {
        Optional<Plan> planOptional = planRepository.findById(planId);

        return planOptional.orElse(null);
    }
    @Override
    public Plan getByIdLazy(int planId) throws Exception {
        Optional<Plan> planOptional = planRepository.findByIdLazy(planId);

        return planOptional.orElse(null);
    }
    @Override
    public PlanReadDTO getDTOById(int planId) throws Exception {
        Plan plan = getById(planId);

        if (plan == null)
            return null;

        return dtoWrapperSingle(plan);
    }

    @Override
    public List<Plan> getAllByIdIn(Collection<Integer> planIdCollection) throws Exception {
        List<Plan> planList =
                planRepository.findAllByPlanIdIn(planIdCollection);

        if (planList.isEmpty())
            return null;

        return planList;
    }
    @Override
    public List<PlanReadDTO> getAllDTOByIdIn(Collection<Integer> planIdCollection) throws Exception {
        List<Plan> planList =
                getAllByIdIn(planIdCollection);

        if (planList == null)
            return null;

        return dtoWrapperBulk(planList);
    }

    /* UPDATE */
    @Override
    public Plan updatePlan(Plan plan, LogReason logReason, String logNote) throws Exception {
        int planId = plan.getPlanId();

        /* exists by Id */
        Plan oldPlan = getByIdLazy(planId);
        if (oldPlan == null)
            throw new IllegalArgumentException("No such Plan found with Id: " + planId);

        /* Validate input */
        if (plan.getPlanStart().after(plan.getPlanEnd())) /* Check date */
            throw new IllegalArgumentException(
                    "StartDate cannot be after EndDate. Update Aborted.");

        /* Check duplicate */
        if (planRepository.isDuplicateUpdate(plan.getPlanCode(), planId))
            throw new IllegalArgumentException(
                    "Duplication found when updating Plan with Id: " + planId + ". Update Aborted.");

        /* Update Plan */
        plan = planRepository.saveAndFlush(plan);

        /* Update Log */
        PlanLog latestLog;
        try {
            latestLog = planLogService.getLatestByPlanId(planId);
            if (latestLog != null) { /* Has log, update latest log => old log */
                latestLog.setIsLatest(false);
                latestLog.setPlan(plan); /* TODO: remove this, to save on space */
                planLogService.updatePlanLog(latestLog);
                latestLog = null; /* Refresh */
            }

            latestLog = mapper.map(plan, PlanLog.class);
            latestLog.setPlan(plan); /* TODO: remove this, to save on space */
            if (logReason == null) {
                latestLog.setLogReason(LogReason.UPDATE.stringValue);
            } else {
                latestLog.setLogReason(logReason.stringValue);
            }

            latestLog.setLogNote(logNote);
            planLogService.createPlanLog(latestLog);
        } catch(Exception e) {
            planRepository.save(oldPlan);
            throw new RuntimeException(
                    "Plan Updated. But error for updating Log for Plan with Id: " + planId +
                            ". Update reverted.");
        }

        return plan;
    }
    @Override
    public PlanReadDTO updatePlanByDTO(PlanUpdateDTO planDTO, LogReason logReason, String logNote) throws Exception {
        Plan plan = mapper.map(planDTO, Plan.class);

        plan = updatePlan(plan, logReason, logNote);

        return dtoWrapperSingle(plan);
    }

    /* DELETE */
    @Override
    public boolean deletePlan(int planId) throws Exception {
        /* exists by Id */
        Plan plan = getById(planId);

        if (plan == null)
            throw new IllegalArgumentException(
                    "No such Plan found with Id: " + planId + ". Delete Aborted.");

        plan.setStatus("DELETED");

        /* TODO: replace with enum, deleted related, cascade */

        planRepository.saveAndFlush(plan);

        /* Cascade delete FK */

        return false;
    }

    /* UTIL */
    /** Wrapper class for all getDTO... in @Service. Unifying return */
    private PlanReadDTO dtoWrapperSingle(Plan plan) throws Exception {
        /* Map to DTO */
        PlanReadDTO dto = mapper.map(plan, PlanReadDTO.class);

        /* Mapping FK */
        List<Plan> childPlanList = plan.getChildPlanList();
        if (childPlanList != null && !childPlanList.isEmpty()) {
            dto.setChildPlanList(dtoWrapperBulk(childPlanList));
        }

        return dto;
    }

    /** Wrapper class for all getAllDTO... in @Service. Unifying return. */
    /* TODO: Currently looping costing memory */
    private List<PlanReadDTO> dtoWrapperBulk(Collection<Plan> planCollection) throws Exception {
        List<PlanReadDTO> planDTOList = new ArrayList<>();

        List<Plan> tmplist;
        PlanReadDTO dto;
        for (Plan plan : planCollection) {
            /* Map to DTO */
            dto = mapper.map(plan, PlanReadDTO.class);

            /* Mapping FK */
            tmplist = plan.getChildPlanList();
            if (tmplist != null && !tmplist.isEmpty()) {
                dto.setChildPlanList(dtoWrapperBulk(tmplist));
            }

            planDTOList.add(dto);
        }

        return planDTOList;
    }

}

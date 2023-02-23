package com.publisher.modules.planAndTask.services.planLog;

import com.publisher.modules.planAndTask.dtos.planLog.PlanLogCreateDTO;
import com.publisher.modules.planAndTask.dtos.planLog.PlanLogReadDTO;
import com.publisher.modules.planAndTask.dtos.planLog.PlanLogUpdateDTO;
import com.publisher.modules.planAndTask.entities.Plan;
import com.publisher.modules.planAndTask.entities.PlanLog;
import com.publisher.modules.planAndTask.repositories.PlanLogRepository;
import com.publisher.modules.planAndTask.services.plan.PlanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PlanLogServiceImpl implements PlanLogService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PlanLogRepository planLogRepository;
    @Lazy /* Avoid circular injection */
    @Autowired
    private PlanService planService;



/* CREATE */
    @Override
    public PlanLog createPlanLog(PlanLog planLog) throws Exception {
        /* Validate input */
        if (planLog.getPlanStart().after(planLog.getPlanEnd())) {/* Check date */
            throw new IllegalArgumentException(
                    "StartDate cannot be after EndDate. Create Aborted."); }

        /* Check Duplicate */ /* Allow duplicate */

        /* Check FK */
        Plan plan = planLog.getPlan();
        if (plan == null) {
            int planId = planLog.getPlanId();
            plan = planService.getByIdLazy(planId);

            if (plan == null) {
                throw new IllegalArgumentException(
                        "No such Plan found with Id: " + planId + ". Create Aborted."); }

            planLog.setPlan(plan);
        } else if (!plan.getPlanId().equals(planLog.getPlanId())) {
            throw new IllegalArgumentException(
                    "PlanId mismatch: " + plan.getPlanId() + " vs" + planLog.getPlanId() + ". Create Aborted."); }

        /* Create Log */
        return planLogRepository.saveAndFlush(planLog);
    }
    @Override
    public PlanLogReadDTO createPlanLogByDTO(PlanLogCreateDTO planLogDTO) throws Exception {
        PlanLog planLog = mapper.map(planLogDTO, PlanLog.class);

        planLog = createPlanLog(planLog);

        return dtoWrapperSingle(planLog);
    }

/* READ */
    @Override
    public boolean existsById(int planLogId) throws Exception {
        return planLogRepository.existsById(planLogId);
    }
    @Override
    public PlanLog getById(int planLogId) throws Exception {
        Optional<PlanLog> planLogOptional = planLogRepository.findById(planLogId);

        return planLogOptional.orElse(null);
    }
    @Override
    public PlanLogReadDTO getDTOById(int planLogId) throws Exception {
        PlanLog planLog = getById(planLogId);

        if (planLog == null) {
            return null; }

        return dtoWrapperSingle(planLog);
    }

    @Override
    public List<PlanLog> getAllByIdIn(Collection<Integer> planLogIdCollection) throws Exception {
        List<PlanLog> planLogList =
                planLogRepository.findAllByLogIdIn(planLogIdCollection);

        if (planLogList.isEmpty()) {
            return null; }

        return planLogList;
    }
    @Override
    public List<PlanLogReadDTO> getAllDTOByIdIn(Collection<Integer> planLogIdCollection) throws Exception {
        List<PlanLog> planLogList =
                getAllByIdIn(planLogIdCollection);

        if (planLogList == null) {
            return null; }

        return dtoWrapperBulk(planLogList);
    }

    /* planId */
    @Override
    public PlanLog getLatestByPlanId(int planId) throws Exception {
        Optional<PlanLog> planLogOptional =
                planLogRepository.findByPlanIdAndIsLatestIsTrue(planId);

        return planLogOptional.orElse(null);
    }
    @Override
    public PlanLogReadDTO getLatestDTOByPlanId(int planId) throws Exception {
        PlanLog planLog =
                getLatestByPlanId(planId);

        if (planLog == null) {
            return null; }

        return dtoWrapperSingle(planLog);
    }

    @Override
    public List<PlanLog> getAllByPlanId(int planId) throws Exception {
        List<PlanLog> planLogList =
                planLogRepository.findAllByPlanId(planId);

        if (planLogList.isEmpty()) {
            return null; }

        return planLogList;
    }
    @Override
    public List<PlanLogReadDTO> getAllDTOByPlanId(int planId) throws Exception {
        List<PlanLog> planLogList =
                getAllByPlanId(planId);

        if (planLogList == null) {
            return null; }

        return dtoWrapperBulk(planLogList);
    }

/* UPDATE */
    @Override
    public PlanLog updatePlanLog(PlanLog planLog) throws Exception {
        int logId = planLog.getLogId();

        /* Check exists */
        PlanLog oldLog = getById(logId);
        if (oldLog == null) {
            throw new IllegalArgumentException(
                    "No such PlanLog found with Id: " + logId + ". Update Aborted."); }

        /* Validate input */
        if (planLog.getPlanStart().after(planLog.getPlanEnd())) {/* Check date */
            throw new IllegalArgumentException(
                    "StartDate cannot be after EndDate. Update Aborted."); }

        /* Check FK */
        Plan plan = planLog.getPlan();
        if (plan == null) {
            int planId = planLog.getPlanId();
            plan = planService.getByIdLazy(planId);

            if (plan == null) {
                throw new IllegalArgumentException(
                        "No such Plan found with Id: " + planId + ". Update Aborted."); }

            planLog.setPlan(plan);
        } else if (!plan.getPlanId().equals(planLog.getPlanId())) {
            throw new IllegalArgumentException(
                    "PlanId mismatch: " + plan.getPlanId() + " vs" + planLog.getPlanId() + ". Create Aborted."); }

        return planLogRepository.saveAndFlush(planLog);
    }
    @Override
    public PlanLogReadDTO updatePlanLogByDTO(PlanLogUpdateDTO planLogDTO) throws Exception {
        PlanLog planLog = mapper.map(planLogDTO, PlanLog.class);

        planLog = createPlanLog(planLog);

        return dtoWrapperSingle(planLog);
    }

/* DELETE */
    @Override
    public boolean deletePlanLog(int planLogId) throws Exception {
        /*TODO: NOT YET*/
        return false;
    }

/* UTIL */
    /** Wrapper class for all getDTO... in @Service. Unifying return */
    private PlanLogReadDTO dtoWrapperSingle(PlanLog planLog) throws Exception {
        /* Map to DTO */
        PlanLogReadDTO dto = mapper.map(planLog, PlanLogReadDTO.class);

        /* Mapping FK */

        return dto;
    }

    /** Wrapper class for all getAllDTO... in @Service. Unifying return */
    private List<PlanLogReadDTO> dtoWrapperBulk(Collection<PlanLog> planLogCollection) throws Exception {
        List<PlanLogReadDTO> planLogDTOList = new ArrayList<>();

        PlanLogReadDTO dto;
        for (PlanLog planLog : planLogCollection) {
            /* Map to DTO */
            dto = mapper.map(planLog, PlanLogReadDTO.class);

            /* Mapping FK */

            planLogDTOList.add(dto);
        }

        return planLogDTOList;
    }

}

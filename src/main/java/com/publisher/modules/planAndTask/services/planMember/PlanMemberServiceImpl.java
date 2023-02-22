package com.publisher.modules.planAndTask.services.planMember;

import com.publisher.modules.employeeAndAccount.entities.Employee;
import com.publisher.modules.employeeAndAccount.services.employee.EmployeeService;
import com.publisher.modules.planAndTask.dtos.planMember.PlanMemberCreateDTO;
import com.publisher.modules.planAndTask.dtos.planMember.PlanMemberReadDTO;
import com.publisher.modules.planAndTask.dtos.planMember.PlanMemberUpdateDTO;
import com.publisher.modules.planAndTask.entities.Plan;
import com.publisher.modules.planAndTask.entities.PlanMember;
import com.publisher.modules.planAndTask.repositories.PlanMemberRepository;
import com.publisher.modules.planAndTask.services.plan.PlanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PlanMemberServiceImpl implements PlanMemberService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PlanMemberRepository planMemberRepository;
    @Autowired
    private PlanService planService;
    @Autowired
    private EmployeeService employeeService;



/* CREATE */
    @Override
    public PlanMember createPlanMember(PlanMember planMember) throws Exception {
        int planId = planMember.getPlanId();
        int employeeId = planMember.getEmployeeId();

        /* Validate input */
        Timestamp memberTo = planMember.getMemberTo();
        if (memberTo != null)
            if (planMember.getMemberFrom().after(memberTo))
                throw new  IllegalArgumentException(
                        "FromDate cannot be after ToDate. Create Aborted.");

        /* Check duplicate */
        /* TODO: Integrate memberFrom - To into check duplicate, ignore already expired */
        if (planMemberRepository.isDuplicateInsert(planId, employeeId))
            throw new IllegalArgumentException(
                    "Duplication found when creating Plan. Create Aborted.");

        /* Check FK */
        Plan plan = planService.getByIdLazy(planId);
        if (plan == null)
            throw new IllegalArgumentException(
                    "No Plan found with Id: " + planId + ". Create Aborted.");

        Employee employee = employeeService.getByIdLazy(employeeId);
        if (employee == null)
            throw new IllegalArgumentException(
                    "No Employee found with Id: " + employeeId + ". Create Aborted.");

        planMember.setPlan(plan);
        planMember.setEmployee(employee);

        return planMemberRepository.saveAndFlush(planMember);
    }
    @Override
    public PlanMemberReadDTO createPlanMemberByDTO(PlanMemberCreateDTO planMemberDTO) throws Exception {
        PlanMember planMember = mapper.map(planMemberDTO, PlanMember.class);

        planMember = createPlanMember(planMember);

        return dtoWrapperSingle(planMember);
    }

    @Override
    public List<PlanMember> createBulkPlanMember(Collection<PlanMember> planMemberCollection) throws Exception {
        return null;
    }
    @Override
    public List<PlanMemberReadDTO> createBulkPlanMemberByDTO(Collection<PlanMemberCreateDTO> planMemberDTOCollection) throws Exception {
        return null;
    }

    /* READ */
    @Override
    public boolean existsById(int memberId) throws Exception {
        return planMemberRepository.existsById(memberId);
    }
    @Override
    public PlanMember getById(int memberId) throws Exception {
        Optional<PlanMember> planMemberOptional = planMemberRepository.findById(memberId);

        return planMemberOptional.orElse(null);
    }
    @Override
    public PlanMemberReadDTO getDTOById(int memberId) throws Exception {
        PlanMember planMember = getById(memberId);

        if (planMember == null)
            return null;

        return dtoWrapperSingle(planMember);
    }

    @Override
    public List<PlanMember> getAllByIdIn(Collection<Integer> memberIdCollection) throws Exception {
        List<PlanMember> planMemberList =
                planMemberRepository.findAllByMemberIdIn(memberIdCollection);

        if (planMemberList.isEmpty())
            return null;

        return planMemberList;
    }
    @Override
    public List<PlanMemberReadDTO> getAllDTOByIdIn(Collection<Integer> memberIdCollection) throws Exception {
        List<PlanMember> planMemberList =
                getAllByIdIn(memberIdCollection);

        if (planMemberList == null)
            return null;

        return dtoWrapperBulk(planMemberList);
    }

    /* planId */
    @Override
    public List<PlanMember> getAllByPlanId(int planId) throws Exception {
        List<PlanMember> planMemberList =
                planMemberRepository.findAllByPlanId(planId);

        if (planMemberList.isEmpty())
            return null;

        return planMemberList;
    }
    @Override
    public List<PlanMemberReadDTO> getAllDTOByPlanId(int planId) throws Exception {
        List<PlanMember> planMemberList =
                getAllByPlanId(planId);

        if (planMemberList == null)
            return null;

        return dtoWrapperBulk(planMemberList);
    }

    @Override
    public List<PlanMember> getAllByPlanIdIn(Collection<Integer> planIdCollection) throws Exception {
        List<PlanMember> planMemberList =
                planMemberRepository.findAllByPlanIdIn(planIdCollection);

        if (planMemberList.isEmpty())
            return null;

        return planMemberList;
    }
    @Override
    public List<PlanMemberReadDTO> getAllDTOByPlanIdIn(Collection<Integer> planIdCollection) throws Exception {
        List<PlanMember> planMemberList =
                getAllByPlanIdIn(planIdCollection);

        if (planMemberList == null)
            return null;

        return dtoWrapperBulk(planMemberList);
    }

    /* employeeId */
    @Override
    public List<PlanMember> getAllByEmployeeId(int employeeId) throws Exception {
        List<PlanMember> planMemberList =
                planMemberRepository.findAllByEmployeeId(employeeId);

        if (planMemberList.isEmpty())
            return null;

        return planMemberList;
    }
    @Override
    public List<PlanMemberReadDTO> getAllDTOByEmployeeId(int employeeId) throws Exception {
        List<PlanMember> planMemberList =
                getAllByEmployeeId(employeeId);

        if (planMemberList == null)
            return null;

        return dtoWrapperBulk(planMemberList);
    }

    @Override
    public List<PlanMember> getAllByEmployeeIdIn(Collection<Integer> employeeIdCollection) throws Exception {
        List<PlanMember> planMemberList =
                planMemberRepository.findAllByEmployeeIdIn(employeeIdCollection);

        if (planMemberList.isEmpty())
            return null;

        return planMemberList;
    }
    @Override
    public List<PlanMemberReadDTO> getAllDTOByEmployeeIdIn(Collection<Integer> employeeIdCollection) throws Exception {
        List<PlanMember> planMemberList =
                getAllByEmployeeIdIn(employeeIdCollection);

        if (planMemberList == null)
            return null;

        return dtoWrapperBulk(planMemberList);
    }

/* UPDATE */
    @Override
    public PlanMember updatePlanMember(PlanMember planMember) throws Exception {
        return null;
    }
    @Override
    public PlanMemberReadDTO updatePlanMemberByDTO(PlanMemberUpdateDTO planMemberDTO) throws Exception {
        return null;
    }

/* DELETE */
    @Override
    public boolean deletePlanMember(int memberId) throws Exception {
        /*TODO: NOT YET*/
        return false;
    }

/* UTIL */
    /** Wrapper class for all getDTO... in @Service. Unifying return */
    private PlanMemberReadDTO dtoWrapperSingle(PlanMember planMember) throws Exception {
        /* Map to DTO */
        PlanMemberReadDTO dto = mapper.map(planMember, PlanMemberReadDTO.class);

        /* Mapping FK */

        return dto;
    }

    /** Wrapper class for all getAllDTO... in @Service. Unifying return */
    private List<PlanMemberReadDTO> dtoWrapperBulk(Collection<PlanMember> planMemberCollection) throws Exception {
        List<PlanMemberReadDTO> planMemberDTOList = new ArrayList<>();

        PlanMemberReadDTO dto;
        for (PlanMember planMember : planMemberCollection) {
            /* Map to DTO */
            dto = mapper.map(planMember, PlanMemberReadDTO.class);

            /* Mapping FK */

            planMemberDTOList.add(dto);
        }

        return planMemberDTOList;
    }

}

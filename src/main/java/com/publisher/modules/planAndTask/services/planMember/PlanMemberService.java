package com.publisher.modules.planAndTask.services.planMember;


import com.publisher.modules.planAndTask.dtos.planMember.PlanMemberCreateDTO;
import com.publisher.modules.planAndTask.dtos.planMember.PlanMemberReadDTO;
import com.publisher.modules.planAndTask.dtos.planMember.PlanMemberUpdateDTO;
import com.publisher.modules.planAndTask.entities.PlanMember;

import java.util.Collection;
import java.util.List;

public interface PlanMemberService {
/* CREATE */
    PlanMember createPlanMember(PlanMember planMember) throws Exception;
    PlanMemberReadDTO createPlanMemberByDTO(PlanMemberCreateDTO planMemberDTO) throws Exception;

    List<PlanMember> createBulkPlanMember(Collection<PlanMember> planMemberCollection) throws Exception;
    List<PlanMemberReadDTO> createBulkPlanMemberByDTO(Collection<PlanMemberCreateDTO> planMemberDTOCollection) throws Exception;

/* READ */
    boolean existsById(int memberId) throws Exception;
    PlanMember getById(int memberId) throws Exception;
    PlanMemberReadDTO getDTOById(int memberId) throws Exception;

    List<PlanMember> getAllByIdIn(Collection<Integer> memberIdCollection) throws Exception;
    List<PlanMemberReadDTO> getAllDTOByIdIn(Collection<Integer> memberIdCollection) throws Exception;

    /* planId */
    List<PlanMember> getAllByPlanId(int planId) throws Exception;
    List<PlanMemberReadDTO> getAllDTOByPlanId(int planId) throws Exception;

    List<PlanMember> getAllByPlanIdIn(Collection<Integer> planIdCollection) throws Exception;
    List<PlanMemberReadDTO> getAllDTOByPlanIdIn(Collection<Integer> planIdCollection) throws Exception;

    /* employeeId */
    List<PlanMember> getAllByEmployeeId(int employeeId) throws Exception;
    List<PlanMemberReadDTO> getAllDTOByEmployeeId(int employeeId) throws Exception;

    List<PlanMember> getAllByEmployeeIdIn(Collection<Integer> employeeIdCollection) throws Exception;
    List<PlanMemberReadDTO> getAllDTOByEmployeeIdIn(Collection<Integer> employeeIdCollection) throws Exception;

/* UPDATE */
    PlanMember updatePlanMember(PlanMember planMember) throws Exception;
    PlanMemberReadDTO updatePlanMemberByDTO(PlanMemberUpdateDTO planMemberDTO) throws Exception;


/* DELETE */
    boolean deletePlanMember(int memberId) throws Exception;

}

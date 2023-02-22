package com.publisher.modules.planAndTask.services.plan;


import com.publisher.modules.planAndTask.dtos.plan.PlanCreateDTO;
import com.publisher.modules.planAndTask.dtos.plan.PlanReadDTO;
import com.publisher.modules.planAndTask.dtos.plan.PlanUpdateDTO;
import com.publisher.modules.planAndTask.entities.Plan;
import com.publisher.utils.enums.LogReason;

import java.util.Collection;
import java.util.List;

public interface PlanService {
    /* CREATE */
    Plan createPlan(Plan plan) throws Exception;
    PlanReadDTO createPlanByDTO(PlanCreateDTO planDTO) throws Exception;

    /* READ */
    boolean existsById(int planId) throws Exception;
    Plan getById(int planId) throws Exception;
    /** Using Fetch LAZY, default is EAGER */
    Plan getByIdLazy(int planId) throws Exception;
    PlanReadDTO getDTOById(int planId) throws Exception;

    List<Plan> getAllByIdIn(Collection<Integer> planIdCollection) throws Exception;
    List<PlanReadDTO> getAllDTOByIdIn(Collection<Integer> planIdCollection) throws Exception;

    /* UPDATE */
    Plan updatePlan(Plan plan, LogReason logReason, String logNote) throws Exception;
    PlanReadDTO updatePlanByDTO(PlanUpdateDTO planDTO, LogReason logReason, String logNote) throws Exception;


    /* DELETE */
    boolean deletePlan(int planId) throws Exception;

}

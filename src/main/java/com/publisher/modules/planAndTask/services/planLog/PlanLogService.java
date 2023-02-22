package com.publisher.modules.planAndTask.services.planLog;


import com.publisher.modules.planAndTask.dtos.planLog.PlanLogCreateDTO;
import com.publisher.modules.planAndTask.dtos.planLog.PlanLogReadDTO;
import com.publisher.modules.planAndTask.dtos.planLog.PlanLogUpdateDTO;
import com.publisher.modules.planAndTask.entities.PlanLog;

import java.util.Collection;
import java.util.List;

public interface PlanLogService {
/* CREATE */
    PlanLog createPlanLog(PlanLog planLog) throws Exception;
    PlanLogReadDTO createPlanLogByDTO(PlanLogCreateDTO planLogDTO) throws Exception;

/* READ */
    boolean existsById(int planLogId) throws Exception;
    PlanLog getById(int planLogId) throws Exception;
    PlanLogReadDTO getDTOById(int planLogId) throws Exception;

    List<PlanLog> getAllByIdIn(Collection<Integer> planLogIdCollection) throws Exception;
    List<PlanLogReadDTO> getAllDTOByIdIn(Collection<Integer> planLogIdCollection) throws Exception;

    /* planId */
    PlanLog getLatestByPlanId(int planId) throws Exception;
    PlanLogReadDTO getLatestDTOByPlanId(int planId) throws Exception;

    List<PlanLog> getAllByPlanId(int planId) throws Exception;
    List<PlanLogReadDTO> getAllDTOByPlanId(int planId) throws Exception;

/* UPDATE */
    PlanLog updatePlanLog(PlanLog planLog) throws Exception;
    PlanLogReadDTO updatePlanLogByDTO(PlanLogUpdateDTO planLogDTO) throws Exception;

/* DELETE */
    boolean deletePlanLog(int planLogId) throws Exception;

}

package com.publisher.modules.planAndTask.services.constraint;


import com.publisher.modules.planAndTask.dtos.constraint.ConstraintCreateDTO;
import com.publisher.modules.planAndTask.dtos.constraint.ConstraintReadDTO;
import com.publisher.modules.planAndTask.dtos.constraint.ConstraintUpdateDTO;
import com.publisher.modules.planAndTask.entities.Constraint;

import java.util.Collection;
import java.util.List;

public interface ConstraintService {
/* CREATE */
    Constraint createConstraint(Constraint constraint) throws Exception;
    ConstraintReadDTO createConstraintByDTO(ConstraintCreateDTO constraintDTO) throws Exception;

/* READ */
    boolean existsById(int constraintId) throws Exception;
    Constraint getById(int constraintId) throws Exception;
    ConstraintReadDTO getDTOById(int constraintId) throws Exception;

    List<Constraint> getAllByIdIn(Collection<Integer> constraintIdCollection) throws Exception;
    List<ConstraintReadDTO> getAllDTOByIdIn(Collection<Integer> constraintIdCollection) throws Exception;

    /* planId */
    List<Constraint> getAllByConstraintPlanId(int planId) throws Exception;
    List<ConstraintReadDTO> getAllDTOByConstraintPlanId(int planId) throws Exception;

    List<Constraint> getAllByConstraintPlanIdIn(Collection<Integer> planIdCollection) throws Exception;
    List<ConstraintReadDTO> getAllDTOByConstraintPlanIdIn(Collection<Integer> planIdCollection) throws Exception;

    List<Constraint> getAllByAffectedPlanId(int planId) throws Exception;
    List<ConstraintReadDTO> getAllDTOByAffectedPlanId(int planId) throws Exception;

    List<Constraint> getAllByAffectedPlanIdIn(Collection<Integer> planIdCollection) throws Exception;
    List<ConstraintReadDTO> getAllDTOByAffectedPlanIdIn(Collection<Integer> planIdCollection) throws Exception;

    /* taskId */
    List<Constraint> getAllByConstraintTaskId(int taskId) throws Exception;
    List<ConstraintReadDTO> getAllDTOByConstraintTaskId(int taskId) throws Exception;

    List<Constraint> getAllByConstraintTaskIdIn(Collection<Integer> taskIdCollection) throws Exception;
    List<ConstraintReadDTO> getAllDTOByConstraintTaskIdIn(Collection<Integer> taskIdCollection) throws Exception;

    List<Constraint> getAllByAffectedTaskId(int taskId) throws Exception;
    List<ConstraintReadDTO> getAllDTOByAffectedTaskId(int taskId) throws Exception;

    List<Constraint> getAllByAffectedTaskIdIn(Collection<Integer> taskIdCollection) throws Exception;
    List<ConstraintReadDTO> getAllDTOByAffectedTaskIdIn(Collection<Integer> taskIdCollection) throws Exception;

/* UPDATE */
    Constraint updateConstraint(Constraint constraint) throws Exception;
    ConstraintReadDTO updateConstraintByDTO(ConstraintUpdateDTO constraintDTO) throws Exception;


/* DELETE */
    boolean deleteConstraint(int constraintId) throws Exception;

}

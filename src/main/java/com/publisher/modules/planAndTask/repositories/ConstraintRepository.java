package com.publisher.modules.planAndTask.repositories;

import com.publisher.modules.planAndTask.entities.Constraint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ConstraintRepository extends
        JpaRepository<Constraint, Integer>,
        JpaSpecificationExecutor<Constraint> {

    /* Id */
    List<Constraint> findAllByConstraintIdIn(Collection<Integer> constraintIdCollection);

    /* PlanId */
    List<Constraint> findAllByConstraintPlanId(int planId);
    List<Constraint> findAllByConstraintPlanIdIn(Collection<Integer> planIdCollection);

    List<Constraint> findAllByAffectedPlanId(int planId);
    List<Constraint> findAllByAffectedPlanIdIn(Collection<Integer> planIdCollection);

    /* TaskId */
    List<Constraint> findAllByConstraintTaskId(int taskId);
    List<Constraint> findAllByConstraintTaskIdIn(Collection<Integer> taskIdCollection);

    List<Constraint> findAllByAffectedTaskId(int taskId);
    List<Constraint> findAllByAffectedTaskIdIn(Collection<Integer> taskIdCollection);


}
package com.publisher.modules.planAndTask.repositories;

import com.publisher.modules.planAndTask.entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlanRepository extends
        JpaRepository<Plan, Integer>,
        JpaSpecificationExecutor<Plan> {

    /* Id */
    @Query("select p from Plan p where p.planId = ?1")
    Optional<Plan> findByIdLazy(int planId);
    List<Plan> findAllByPlanIdIn(Collection<Integer> planIdCollection);

    /* Check duplicate */
    @Query("select case when count(p) > 0 then true else false end from Plan p " +
            "where p.planCode = ?1")
    boolean isDuplicateInsert(String planCode);

    @Query("select case when count(p) > 0 then true else false end from Plan p " +
            "where p.planCode = ?1 and p.planId <> ?2")
    boolean isDuplicateUpdate(String planCode, int planId);
}
package com.publisher.modules.planAndTask.repositories;

import com.publisher.modules.planAndTask.entities.PlanLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlanLogRepository extends
        JpaRepository<PlanLog, Integer>,
        JpaSpecificationExecutor<PlanLog> {

    /* Id */
    List<PlanLog> findAllByLogIdIn(Collection<Integer> planLogIdCollection);

    /* planId */
    Optional<PlanLog> findByPlanIdAndIsLatestIsTrue(int planId);
    List<PlanLog> findAllByPlanId(int planId);

}
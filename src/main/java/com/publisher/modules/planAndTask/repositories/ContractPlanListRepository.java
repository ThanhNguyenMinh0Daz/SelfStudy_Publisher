package com.publisher.modules.planAndTask.repositories;

import com.publisher.modules.planAndTask.entities.ContractPlanList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractPlanListRepository extends
        JpaRepository<ContractPlanList, Integer>,
        JpaSpecificationExecutor<ContractPlanList> {
}
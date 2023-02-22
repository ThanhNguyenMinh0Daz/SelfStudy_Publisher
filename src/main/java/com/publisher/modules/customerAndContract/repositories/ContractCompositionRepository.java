package com.publisher.modules.customerAndContract.repositories;

import com.publisher.modules.customerAndContract.entities.ContractComposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractCompositionRepository extends
        JpaRepository<ContractComposition, Integer>,
        JpaSpecificationExecutor<ContractComposition> {
}
package com.publisher.modules.customerAndContract.repositories;

import com.publisher.modules.customerAndContract.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends
        JpaRepository<Contract, Integer>,
        JpaSpecificationExecutor<Contract> {
}
package com.publisher.modules.customerAndContract.repositories;

import com.publisher.modules.customerAndContract.entities.CustomerLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerLogRepository extends
        JpaRepository<CustomerLog, Integer>,
        JpaSpecificationExecutor<CustomerLog> {
}
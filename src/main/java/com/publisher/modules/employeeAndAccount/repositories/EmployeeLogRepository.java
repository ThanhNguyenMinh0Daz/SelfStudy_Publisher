package com.publisher.modules.employeeAndAccount.repositories;

import com.publisher.modules.employeeAndAccount.entities.EmployeeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeLogRepository extends
        JpaRepository<EmployeeLog, Integer>,
        JpaSpecificationExecutor<EmployeeLog> {
}
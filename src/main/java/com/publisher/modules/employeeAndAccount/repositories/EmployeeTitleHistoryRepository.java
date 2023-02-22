package com.publisher.modules.employeeAndAccount.repositories;

import com.publisher.modules.employeeAndAccount.entities.EmployeeTitleHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTitleHistoryRepository extends
        JpaRepository<EmployeeTitleHistory, Integer>,
        JpaSpecificationExecutor<EmployeeTitleHistory> {
}
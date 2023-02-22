package com.publisher.modules.employeeAndAccount.repositories;

import com.publisher.modules.employeeAndAccount.entities.Right;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RightRepository extends
        JpaRepository<Right, Integer>,
        JpaSpecificationExecutor<Right> {
}
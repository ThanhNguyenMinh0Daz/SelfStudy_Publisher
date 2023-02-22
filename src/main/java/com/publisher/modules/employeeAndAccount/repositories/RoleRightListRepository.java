package com.publisher.modules.employeeAndAccount.repositories;

import com.publisher.modules.employeeAndAccount.entities.RoleRightList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRightListRepository extends
        JpaRepository<RoleRightList, Integer>,
        JpaSpecificationExecutor<RoleRightList> {
}
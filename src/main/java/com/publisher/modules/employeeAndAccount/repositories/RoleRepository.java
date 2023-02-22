package com.publisher.modules.employeeAndAccount.repositories;

import com.publisher.modules.employeeAndAccount.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends
        JpaRepository<Role, Integer>,
        JpaSpecificationExecutor<Role> {
}
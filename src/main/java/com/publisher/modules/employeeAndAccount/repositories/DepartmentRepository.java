package com.publisher.modules.employeeAndAccount.repositories;

import com.publisher.modules.employeeAndAccount.entities.Department;
import com.publisher.modules.employeeAndAccount.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface DepartmentRepository extends
        JpaRepository<Department, Integer>,
        JpaSpecificationExecutor<Department> {

    /* Id */
    List<Department> findAllByDepartmentIdIn(Collection<Integer> departmentIdCollection);

    /* Check duplicate */
    /* TODO: include checking commonIdentifier */
    @Query("select case when count(d) > 0 then true else false end from Department d " +
            "where d.departmentName = ?1")
    boolean isDuplicateInsert(String departmentName);

    @Query("select case when count(d) > 0 then true else false end from Department d " +
            "where d.departmentName = ?1 and d.departmentId <> ?2")
    boolean isDuplicateUpdate(String departmentName, int employeeId);
}
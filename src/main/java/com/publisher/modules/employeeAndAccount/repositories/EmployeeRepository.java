package com.publisher.modules.employeeAndAccount.repositories;

import com.publisher.modules.employeeAndAccount.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends
        JpaRepository<Employee, Integer>,
        JpaSpecificationExecutor<Employee> {

    /* Id */
    /* TODO: include checking commonIdentifier */
    @Query("select e from Employee e where e.employeeId = ?1")
    Optional<Employee> findByIdLazy(int employeeId);
    List<Employee> findAllByEmployeeIdIn(Collection<Integer> employeeIdCollection);

    /* departmentId */
    List<Employee> findAllByDepartmentId(int departmentId);
    List<Employee> findAllByDepartmentIdIn(Collection<Integer> departmentIdCollection);

    /* Check duplicate */
    /* TODO: include checking commonIdentifier */
    @Query("select case when count(e) > 0 then true else false end from Employee e " +
            "where e.nationalId = ?1")
    boolean isDuplicateInsert(String nationalId);

    @Query("select case when count(e) > 0 then true else false end from Employee e " +
            "where e.nationalId = ?1 and e.employeeId <> ?2")
    boolean isDuplicateUpdate(String nationalId, int employeeId);
}
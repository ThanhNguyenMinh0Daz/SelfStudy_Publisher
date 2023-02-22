package com.publisher.modules.employeeAndAccount.services.employee;


import com.publisher.modules.employeeAndAccount.dtos.employee.EmployeeCreateDTO;
import com.publisher.modules.employeeAndAccount.dtos.employee.EmployeeReadDTO;
import com.publisher.modules.employeeAndAccount.dtos.employee.EmployeeUpdateDTO;
import com.publisher.modules.employeeAndAccount.entities.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
/* CREATE */
    Employee createEmployee(Employee employee) throws Exception;
    EmployeeReadDTO createEmployeeByDTO(EmployeeCreateDTO employeeDTO) throws Exception;

/* READ */
    boolean existsById(int employeeId) throws Exception;
    Employee getById(int employeeId) throws Exception;
    Employee getByIdLazy(int employeeId) throws Exception;
    EmployeeReadDTO getDTOById(int employeeId) throws Exception;

    List<Employee> getAllByIdIn(Collection<Integer> employeeIdCollection) throws Exception;
    List<EmployeeReadDTO> getAllDTOByIdIn(Collection<Integer> employeeIdCollection) throws Exception;

    /* departmentId */
    List<Employee> getAllByDepartmentId(int departmentId) throws Exception;
    List<EmployeeReadDTO> getAllDTOByDepartmentId(int departmentId) throws Exception;

    List<Employee> getAllByDepartmentIdIn(Collection<Integer> departmentIdCollection) throws Exception;
    List<EmployeeReadDTO> getAllDTOByDepartmentIdIn(Collection<Integer> departmentIdCollection) throws Exception;
    
/* UPDATE */
    Employee updateEmployee(Employee employee) throws Exception;
    EmployeeReadDTO updateEmployeeByDTO(EmployeeUpdateDTO employeeDTO) throws Exception;


/* DELETE */
    boolean deleteEmployee(int employeeId) throws Exception;

}

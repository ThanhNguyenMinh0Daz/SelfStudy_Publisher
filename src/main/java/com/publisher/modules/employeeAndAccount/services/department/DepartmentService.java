package com.publisher.modules.employeeAndAccount.services.department;


import com.publisher.modules.employeeAndAccount.dtos.department.DepartmentCreateDTO;
import com.publisher.modules.employeeAndAccount.dtos.department.DepartmentReadDTO;
import com.publisher.modules.employeeAndAccount.dtos.department.DepartmentUpdateDTO;
import com.publisher.modules.employeeAndAccount.entities.Department;

import java.util.Collection;
import java.util.List;

public interface DepartmentService {
/* CREATE */
    Department createDepartment(Department department) throws Exception;
    DepartmentReadDTO createDepartmentByDTO(DepartmentCreateDTO departmentDTO) throws Exception;

/* READ */
    boolean existsById(int departmentId) throws Exception;
    Department getById(int departmentId) throws Exception;
    DepartmentReadDTO getDTOById(int departmentId) throws Exception;

    List<Department> getAllByIdIn(Collection<Integer> departmentIdCollection) throws Exception;
    List<DepartmentReadDTO> getAllDTOByIdIn(Collection<Integer> departmentIdCollection) throws Exception;

/* UPDATE */
    Department updateDepartment(Department department) throws Exception;
    DepartmentReadDTO updateDepartmentByDTO(DepartmentUpdateDTO departmentDTO) throws Exception;

/* DELETE */
    boolean deleteDepartment(int departmentId) throws Exception;

}

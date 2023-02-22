package com.publisher.modules.employeeAndAccount.dtos.department;

import com.publisher.modules.employeeAndAccount.entities.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link Department} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentReadDTO implements Serializable {
    private Integer departmentId;
    private String departmentName;
    private String departmentDesc;
}
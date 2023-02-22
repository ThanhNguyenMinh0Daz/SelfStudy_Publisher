package com.publisher.modules.employeeAndAccount.dtos.employee;

import com.publisher.modules.employeeAndAccount.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

/**
 * A DTO for the {@link Employee} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeCreateDTO implements Serializable {
    private Integer departmentId;
    private String nationalId;
    private String sex;
    private Date birthDate;
//    private Integer identifierId;
}
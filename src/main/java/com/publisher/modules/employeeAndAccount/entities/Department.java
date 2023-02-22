package com.publisher.modules.employeeAndAccount.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "department")
public class Department {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "departmentId", nullable = false)
    private Integer departmentId;
    
    @Column(name = "departmentName", nullable = false, length = 45)
    private String departmentName;
    
    @Column(name = "departmentDesc", nullable = true, length = -1)
    private String departmentDesc;

    @OneToMany(mappedBy = "department")
    private List<Employee> employeeList;
}

package com.publisher.modules.employeeAndAccount.entities;

import com.publisher.modules.planAndTask.entities.PlanMember;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "employeeId", nullable = false)
    private Integer employeeId;

    @ManyToOne
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
    private Department department;
    @Column(name = "departmentId", nullable = false, insertable = false, updatable = false)
    private Integer departmentId;
    
    @Column(name = "nationalId", nullable = false, length = 45)
    private String nationalId;
    
    @Column(name = "sex", nullable = false, length = 45)
    private String sex;
    
    @Column(name = "birthDate", nullable = false)
    private Date birthDate;

//    @OneToOne
//    @JoinColumn(name = "identifierId", referencedColumnName = "identifierId")
//    private CommonIdentifier commonIdentifier;
//    @Column(name = "identifierId", nullable = false, insertable = false, updatable = false)
//    private Integer identifierId;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeTitleHistory> employeeTitleHistoryList;

    @OneToMany(mappedBy = "employee")
    private List<PlanMember> planMemberList;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeLog> employeeLogList;
}

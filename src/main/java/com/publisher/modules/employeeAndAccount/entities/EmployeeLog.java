package com.publisher.modules.employeeAndAccount.entities;

import com.publisher.modules.common.entities.CommonLog;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee_log")
@PrimaryKeyJoinColumn(name = "logId", referencedColumnName = "logId")
public class EmployeeLog extends CommonLog {
    @OneToOne
    @MapsId
    @JoinColumn(name = "logId", referencedColumnName = "logId")
    private CommonLog commonLog;
    @Column(name = "logId", nullable = false, insertable = false, updatable = false)
    private Integer logId;

    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;
    @Column(name = "employeeId", nullable = false, insertable = false, updatable = false)
    private Integer employeeId;
    
    @Column(name = "nationalId", nullable = false, length = 45)
    private String nationalId;
    
    @Column(name = "sex", nullable = false, length = 45)
    private String sex;
    
    @Column(name = "birthDate", nullable = false)
    private Date birthDate;

}

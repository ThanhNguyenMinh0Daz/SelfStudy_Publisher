package com.publisher.modules.employeeAndAccount.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee_title_history")
public class EmployeeTitleHistory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "historyId", nullable = false)
    private Integer historyId;

    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;
    @Column(name = "employeeId", nullable = false, insertable = false, updatable = false)
    private Integer employeeId;

    @ManyToOne
    @JoinColumn(name = "titleId", referencedColumnName = "titleId")
    private Title title;
    @Column(name = "titleId", nullable = false, insertable = false, updatable = false)
    private Integer titleId;
    
    @Column(name = "validFrom", nullable = false)
    private Timestamp validFrom = Timestamp.valueOf(LocalDateTime.now());
    
    @Column(name = "validTo", nullable = true)
    private Timestamp validTo;
}

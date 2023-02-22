package com.publisher.modules.planAndTask.entities;

import com.publisher.modules.employeeAndAccount.entities.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "plan_member")
public class PlanMember {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "memberId", nullable = false)
    private Integer memberId;

    @ManyToOne
    @JoinColumn(name = "planId", referencedColumnName = "planId")
    private Plan plan;
    @Column(name = "planId", nullable = false, insertable = false, updatable = false)
    private Integer planId;

    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;
    @Column(name = "employeeId", nullable = false, insertable = false, updatable = false)
    private Integer employeeId;
    
    @Column(name = "memberRole", nullable = true, length = 45)
    private String memberRole;
    
    @Column(name = "memberFrom", nullable = true)
    private Timestamp memberFrom;
    
    @Column(name = "memberTo", nullable = true)
    private Timestamp memberTo;

    @OneToMany(mappedBy = "planMember")
    private List<TaskAssignment> taskAssignment;
}

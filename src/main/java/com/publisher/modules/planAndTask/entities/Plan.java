package com.publisher.modules.planAndTask.entities;

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
@Table(name = "plan")
public class Plan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "planId", nullable = false)
    private Integer planId;
    @OneToMany(mappedBy = "parentPlan", fetch = FetchType.EAGER)
    private List<Plan> childPlanList;

    @ManyToOne
    @JoinColumn(name = "parentPlanId", referencedColumnName = "planId")
    private Plan parentPlan;
    @Column(name = "parentPlanId", nullable = true, insertable = false, updatable = false)
    private Integer parentPlanId;
    
    @Column(name = "planCode", nullable = false, length = 45)
    private String planCode;
    
    @Column(name = "planDesc", nullable = true, length = 45)
    private String planDesc;
    
    @Column(name = "planStart", nullable = false)
    private Timestamp planStart;
    
    @Column(name = "planEnd", nullable = true)
    private Timestamp planEnd;
    
    @Column(name = "status", nullable = false, length = 45)
    private String status;

    @OneToMany(mappedBy = "constraintPlan")
    private List<Constraint> constraintParticipationList;
    @OneToMany(mappedBy = "affectedPlan")
    private List<Constraint> constraintList;

    @OneToMany(mappedBy = "plan")
    private List<PlanLog> planLogList;

    @OneToMany(mappedBy = "plan")
    private List<Task> taskList;

    @OneToMany(mappedBy = "plan")
    private List<PlanMember> planMemberList;

    @OneToMany(mappedBy = "plan")
    private List<ContractPlanList> contractPlanList;
}

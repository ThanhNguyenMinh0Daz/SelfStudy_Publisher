package com.publisher.modules.planAndTask.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "constraint")
public class Constraint {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "constraintId", nullable = false)
    private Integer constraintId;

    @ManyToOne
    @JoinColumn(name = "constraintPlanId", referencedColumnName = "planId")
    private Plan constraintPlan;
    @Column(name = "constraintPlanId", nullable = true, insertable = false, updatable = false)
    private Integer constraintPlanId;

    @ManyToOne
    @JoinColumn(name = "affectedPlanId", referencedColumnName = "planId")
    private Plan affectedPlan;
    @Column(name = "affectedPlanId", nullable = true, insertable = false, updatable = false)
    private Integer affectedPlanId;

    @ManyToOne
    @JoinColumn(name = "constraintTaskId", referencedColumnName = "taskId")
    private Task constraintTask;
    @Column(name = "constraintTaskId", nullable = true, insertable = false, updatable = false)
    private Integer constraintTaskId;

    @ManyToOne
    @JoinColumn(name = "affectedTaskId", referencedColumnName = "taskId")
    private Task affectedTask;
    @Column(name = "affectedTaskId", nullable = true, insertable = false, updatable = false)
    private Integer affectedTaskId;
    
    @Column(name = "constraintType", nullable = false, length = 45)
    private String constraintType;
    
    @Column(name = "constraintTime", nullable = true, precision = 0)
    private Double constraintTime;
    
    @Column(name = "constraintTimeUnit", nullable = true, length = 45)
    private String constraintTimeUnit;
}

package com.publisher.modules.planAndTask.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "task_assignment")
public class TaskAssignment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "assignmentId", nullable = false)
    private Integer assignmentId;

    @ManyToOne
    @JoinColumn(name = "taskId", referencedColumnName = "taskId")
    private Task task;
    @Column(name = "taskId", nullable = false, insertable = false, updatable = false)
    private Integer taskId;

    @ManyToOne
    @JoinColumn(name = "memberId", referencedColumnName = "memberId")
    private PlanMember planMember;
    @Column(name = "memberId", nullable = false, insertable = false, updatable = false)
    private Integer memberId;
    
    @Column(name = "assignFrom", nullable = true)
    private Timestamp assignFrom;
    
    @Column(name = "assignTo", nullable = true)
    private Timestamp assignTo;
    
    @Column(name = "assignPercent", nullable = true, precision = 0)
    private Double assignPercent;
}

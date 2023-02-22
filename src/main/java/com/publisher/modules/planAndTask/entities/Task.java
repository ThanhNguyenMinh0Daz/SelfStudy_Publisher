package com.publisher.modules.planAndTask.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "task")
public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "taskId", nullable = false)
    private Integer taskId;
    @OneToMany(mappedBy = "parentTask", fetch = FetchType.EAGER)
    private List<Task> childTaskList;

    @ManyToOne
    @JoinColumn(name = "parentTaskId", referencedColumnName = "taskId")
    private Task parentTask;
    @Column(name = "parentTaskId", nullable = true, insertable = false, updatable = false)
    private Integer parentTaskId;

    @ManyToOne
    @JoinColumn(name = "planId", referencedColumnName = "planId")
    private Plan plan;
    @Column(name = "planId", nullable = false, insertable = false, updatable = false)
    private Integer planId;
    
    @Column(name = "taskName", nullable = true, length = 45)
    private String taskName;
    
    @Column(name = "taskDesc", nullable = true, length = 45)
    private String taskDesc;

    @Column(name = "taskCode", nullable = true, length = 45)
    private String taskCode;

    @Column(name = "taskWeight", nullable = true, precision = 0)
    private Double taskWeight;
    
    @Column(name = "taskStart", nullable = true)
    private Timestamp taskStart = Timestamp.valueOf(LocalDateTime.now());
    
    @Column(name = "taskEnd", nullable = true)
    private Timestamp taskEnd;

    @OneToMany(mappedBy = "constraintTask")
    private List<Constraint> constraintParticipationList;
    @OneToMany(mappedBy = "affectedTask")
    private List<Constraint> constraintList;

    @OneToMany(mappedBy = "task")
    private List<TaskAssignment> taskAssignment;
}

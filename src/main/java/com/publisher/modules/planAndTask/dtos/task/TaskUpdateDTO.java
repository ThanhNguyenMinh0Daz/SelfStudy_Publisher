package com.publisher.modules.planAndTask.dtos.task;

import com.publisher.modules.planAndTask.entities.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * A DTO for the {@link Task} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskUpdateDTO implements Serializable {
    private Integer taskId;
    private Integer parentTaskId;
    private Integer planId;
    private String taskName;
    private String taskDesc;
    private String taskCode;
    private Double taskWeight;
    private Timestamp taskStart;
    private Timestamp taskEnd;
}
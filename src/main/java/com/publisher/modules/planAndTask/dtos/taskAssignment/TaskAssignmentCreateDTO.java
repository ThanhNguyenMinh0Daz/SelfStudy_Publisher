package com.publisher.modules.planAndTask.dtos.taskAssignment;

import com.publisher.modules.planAndTask.entities.TaskAssignment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * A DTO for the {@link TaskAssignment} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskAssignmentCreateDTO implements Serializable {
    private Integer taskId;
    private Integer memberId;
    private Timestamp assignFrom;
    private Timestamp assignTo;
    private Double assignPercent;
}
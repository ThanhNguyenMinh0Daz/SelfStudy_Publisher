package com.publisher.modules.planAndTask.dtos.task;

import com.publisher.modules.planAndTask.entities.Task;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link Task} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskCreateDTO implements Serializable {
    private Integer parentTaskId;
    private Integer planId;
    private String taskName;
    private String taskDesc;
    private String taskCode;

    @NotNull
    @PositiveOrZero
    @Max(value = 1)
    private Double taskWeight;

    private Timestamp taskStart = Timestamp.valueOf(LocalDateTime.now());
    private Timestamp taskEnd;
}
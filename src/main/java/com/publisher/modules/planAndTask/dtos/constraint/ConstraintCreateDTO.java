package com.publisher.modules.planAndTask.dtos.constraint;

import com.publisher.modules.planAndTask.entities.Constraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link Constraint} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConstraintCreateDTO implements Serializable {
    private Integer constraintPlanId;
    private Integer affectedPlanId;
    private Integer constraintTaskId;
    private Integer affectedTaskId;
    private String constraintType;
    private Double constraintTime;
    private String constraintTimeUnit;
}
package com.publisher.modules.planAndTask.dtos.plan;

import com.publisher.modules.planAndTask.entities.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * A DTO for the {@link Plan} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlanUpdateDTO implements Serializable {
    private Integer planId;
    private Integer parentPlanId;
    private String planCode;
    private String planDesc;
    private Timestamp planStart;
    private Timestamp planEnd;
    private String status;
}
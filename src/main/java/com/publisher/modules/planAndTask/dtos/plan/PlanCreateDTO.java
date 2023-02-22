package com.publisher.modules.planAndTask.dtos.plan;

import com.publisher.modules.planAndTask.entities.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link Plan} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlanCreateDTO implements Serializable {
    private Integer parentPlanId;
    private String planCode;
    private String planDesc;
    private Timestamp planStart = Timestamp.valueOf(LocalDateTime.now());
    private Timestamp planEnd;
    private String status;
}
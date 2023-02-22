package com.publisher.modules.planAndTask.dtos.plan;

import com.publisher.modules.planAndTask.entities.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * A DTO for the {@link Plan} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlanReadDTO implements Serializable {
    private Integer planId;
    private Integer parentPlanId;
    private String planCode;
    private String planDesc;
    private Timestamp planStart;
    private Timestamp planEnd;
    private String status;

    private List<PlanReadDTO> childPlanList;

    /* Separate to save on data & time */
//    private List<TaskReadDTO> taskList;
}
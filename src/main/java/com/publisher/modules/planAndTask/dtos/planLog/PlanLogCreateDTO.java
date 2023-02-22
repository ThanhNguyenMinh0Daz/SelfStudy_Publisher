package com.publisher.modules.planAndTask.dtos.planLog;

import com.publisher.modules.planAndTask.entities.PlanLog;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * A DTO for the {@link PlanLog} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlanLogCreateDTO implements Serializable {
    private Timestamp logAt;
    private String logReason;
    private String logNote;
    private Boolean isLatest;
    private String status;
    @NotNull
    private Integer planId;
    private String planDesc;
    private Timestamp planStart;
    private Timestamp planEnd;
}
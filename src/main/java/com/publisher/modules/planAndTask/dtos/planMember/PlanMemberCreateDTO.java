package com.publisher.modules.planAndTask.dtos.planMember;

import com.publisher.modules.planAndTask.entities.PlanMember;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * A DTO for the {@link PlanMember} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlanMemberCreateDTO implements Serializable {
    private Integer planId;
    private Integer employeeId;
    private String memberRole;
    private Timestamp memberFrom;
    private Timestamp memberTo;
}
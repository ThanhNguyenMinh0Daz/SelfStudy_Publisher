package com.publisher.modules.planAndTask.entities;

import com.publisher.modules.common.entities.CommonLog;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "plan_log")
@PrimaryKeyJoinColumn(name = "logId", referencedColumnName = "logId")
public class PlanLog extends CommonLog {
    @OneToOne
    @MapsId
    @JoinColumn(name = "logId", referencedColumnName = "logId")
    private CommonLog commonLog;
    @Column(name = "logId", nullable = false, insertable = false, updatable = false)
    private Integer logId;

    @ManyToOne
    @JoinColumn(name = "planId", referencedColumnName = "planId")
    private Plan plan;
    @Column(name = "planId", nullable = false, insertable = false, updatable = false)
    private Integer planId;
    
    @Column(name = "planDesc", nullable = true, length = -1)
    private String planDesc;
    
    @Column(name = "planStart", nullable = false)
    private Timestamp planStart;
    
    @Column(name = "planEnd", nullable = false)
    private Timestamp planEnd;
}

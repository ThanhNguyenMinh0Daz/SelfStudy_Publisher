package com.publisher.modules.common.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "common_log")
@Inheritance(strategy = InheritanceType.JOINED)
public class CommonLog {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "logId", nullable = false)
    private Integer logId;
    
    @Column(name = "logAt", nullable = false)
    private Timestamp logAt = Timestamp.valueOf(LocalDateTime.now());
    
    @Column(name = "logReason", nullable = false, length = 45)
    private String logReason;
    
    @Column(name = "logNote", nullable = true, length = -1)
    private String logNote;
    
    @Column(name = "isLatest", nullable = true)
    private Boolean isLatest = true;
    
    @Column(name = "status", nullable = false, length = 45)
    private String status;
}

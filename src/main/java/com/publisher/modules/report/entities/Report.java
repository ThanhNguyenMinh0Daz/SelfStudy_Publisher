package com.publisher.modules.report.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "report")
public class Report {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reportId", nullable = false)
    private Integer reportId;
    
    @Column(name = "reportType", nullable = false, length = 45)
    private String reportType;
    
    @Column(name = "reportName", nullable = false, length = 45)
    private String reportName;
    
    @Column(name = "reportAt", nullable = false)
    private Timestamp reportAt;
    
    @Column(name = "reportLink", nullable = false, length = -1)
    private String reportLink;
    
    @Column(name = "reportReason", nullable = false, length = 45)
    private String reportReason;

    /** (HTTP / File) Link  of report */
    @Column(name = "report", nullable = false, length = 45)
    private String report;

    @OneToMany(mappedBy = "report")
    private List<ReportItem> reportItemList;
}

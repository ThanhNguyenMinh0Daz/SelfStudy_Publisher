package com.publisher.modules.report.entities;

import com.publisher.modules.customerAndContract.entities.Contract;
import com.publisher.modules.customerAndContract.entities.Customer;
import com.publisher.modules.planAndTask.entities.Plan;
import com.publisher.modules.storage.entities.Item;
import com.publisher.modules.storage.entities.Storage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "report_item")
public class ReportItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reportItemId", nullable = false)
    private Integer reportItemId;
    @OneToMany(mappedBy = "reportItem")
    private List<ReportItem> childReportItemList;

    @ManyToOne
    @JoinColumn(name = "reportId", referencedColumnName = "reportId")
    private Report report;
    @Column(name = "reportId", nullable = false, insertable = false, updatable = false)
    private Integer reportId;

    @ManyToOne
    @JoinColumn(name = "parentReportItemId", referencedColumnName = "reportItemId")
    private ReportItem reportItem;
    @Column(name = "parentReportItemId", nullable = true, insertable = false, updatable = false)
    private Integer parentReportItemId;

    @Column(name = "itemDesc", nullable = true, length = -1)
    private String itemDesc;
    
    @Column(name = "itemType", nullable = true, length = 45)
    private String itemType;
    
    @Column(name = "status", nullable = false, length = 45)
    private String status;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;
    @Column(name = "customerId", nullable = true, insertable = false, updatable = false)
    private Integer customerId;

    @ManyToOne
    @JoinColumn(name = "itemId", referencedColumnName = "itemId")
    private Item item;
    @Column(name = "itemId", nullable = true, insertable = false, updatable = false)
    private Integer itemId;

    @ManyToOne
    @JoinColumn(name = "planId", referencedColumnName = "planId")
    private Plan plan;
    @Column(name = "planId", nullable = true, insertable = false, updatable = false)
    private Integer planId;

    @ManyToOne
    @JoinColumn(name = "storageId", referencedColumnName = "storageId")
    private Storage storage;
    @Column(name = "storageId", nullable = true, insertable = false, updatable = false)
    private Integer storageId;

    @ManyToOne
    @JoinColumn(name = "contractId", referencedColumnName = "contractId")
    private Contract contract;
    @Column(name = "contractId", nullable = true, insertable = false, updatable = false)
    private Integer contractId;
}

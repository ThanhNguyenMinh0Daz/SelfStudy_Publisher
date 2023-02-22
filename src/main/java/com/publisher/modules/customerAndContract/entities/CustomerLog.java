package com.publisher.modules.customerAndContract.entities;

import com.publisher.modules.common.entities.CommonLog;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "customer_log")
@PrimaryKeyJoinColumn(name = "logId", referencedColumnName = "logId")
public class CustomerLog extends CommonLog {
    @OneToOne
    @MapsId
    @JoinColumn(name = "logId", referencedColumnName = "logId")
    private CommonLog commonLog;
    @Column(name = "logId", nullable = false, insertable = false, updatable = false)
    private Integer logId;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;
    @Column(name = "customerId", nullable = false, insertable = false, updatable = false)
    private Integer customerId;
    
    @Column(name = "taxCode", nullable = false, length = 45)
    private String taxCode;
    
    @Column(name = "customerType", nullable = false, length = 45)
    private String customerType;
    
    @Column(name = "businessId", nullable = true, length = 45)
    private String businessId;
    
    @Column(name = "specialization", nullable = true, length = 45)
    private String specialization;
    
    @Column(name = "nationalId", nullable = true, length = 45)
    private String nationalId;
    
    @Column(name = "birthDate", nullable = true)
    private Date birthDate;

}

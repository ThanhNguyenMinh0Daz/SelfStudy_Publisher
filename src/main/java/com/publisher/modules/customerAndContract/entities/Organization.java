package com.publisher.modules.customerAndContract.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "organization")
@PrimaryKeyJoinColumn(name = "organizationId", referencedColumnName = "customerId")
public class Organization extends Customer {
    @OneToOne
    @MapsId
    @JoinColumn(name = "organizationId", referencedColumnName = "customerId")
    private Customer customer;
    @Column(name = "organizationId", nullable = false, insertable = false, updatable = false)
    private Integer organizationId;
    
    @Column(name = "businessId", nullable = false, length = 45)
    private String businessId;
    
    @Column(name = "specialization", nullable = false, length = 45)
    private String specialization;

}

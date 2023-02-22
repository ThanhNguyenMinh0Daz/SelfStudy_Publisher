package com.publisher.modules.customerAndContract.entities;

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
@Table (name = "individual")
@PrimaryKeyJoinColumn(name = "individualId", referencedColumnName = "customerId")
public class Individual extends Customer {
    @OneToOne
    @MapsId
    @JoinColumn(name = "individualId", referencedColumnName = "customerId")
    private Customer customer;
    @Column(name = "individualId", nullable = false, insertable = false, updatable = false)
    private Integer individualId;

    @ManyToOne
    @JoinColumn(name = "organizationId", referencedColumnName = "organizationId")
    private Organization organization;
    @Column(name = "organizationId", nullable = true, insertable = false, updatable = false)
    private Integer organizationId;
    
    @Column(name = "nationalId", nullable = false, length = 45)
    private String nationalId;
    
    @Column(name = "sex", nullable = false, length = 45)
    private String sex;
    
    @Column(name = "birthDate", nullable = false)
    private Date birthDate;
}

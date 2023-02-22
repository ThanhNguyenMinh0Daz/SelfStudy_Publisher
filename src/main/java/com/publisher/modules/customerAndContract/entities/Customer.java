package com.publisher.modules.customerAndContract.entities;

import com.publisher.modules.common.entities.CommonIdentifier;
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
@Table (name = "customer")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "customerId", nullable = false)
    private Integer customerId;

    @OneToOne
    @JoinColumn(name = "identifierId", referencedColumnName = "identifierId")
    private CommonIdentifier commonIdentifier;
    @Column(name = "identifierId", nullable = false, insertable = false, updatable = false)
    private Integer identifierId;
    
    @Column(name = "taxCode", nullable = false, length = 45)
    private String taxCode;
    
    @Column(name = "customerType", nullable = false, length = 45)
    private String customerType;
    
    @Column(name = "status", nullable = false, length = 45)
    private String status;

    @OneToMany(mappedBy = "customer")
    private List<ContractParticipant> contractParticipantList;
}

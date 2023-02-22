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
@Table (name = "contract_participant")
public class ContractParticipant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "participantId", nullable = false)
    private Integer participantId;

    @ManyToOne
    @JoinColumn(name = "contractId", referencedColumnName = "contractId")
    private Contract contract;
    @Column(name = "contractId", nullable = false, insertable = false, updatable = false)
    private Integer contractId;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;
    @Column(name = "customerId", nullable = false, insertable = false, updatable = false)
    private Integer customerId;
    
    @Column(name = "participantType", nullable = false, length = 45)
    private String participantType;


}

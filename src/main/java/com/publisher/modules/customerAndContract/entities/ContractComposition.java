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
@Table (name = "contract_composition")
public class ContractComposition {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "compositionId", nullable = false)
    private Integer compositionId;

    @ManyToOne
    @JoinColumn(name = "contractId", referencedColumnName = "contractId")
    private Contract contract;
    @Column(name = "contractId", nullable = false, insertable = false, updatable = false)
    private Integer contractId;

    @ManyToOne
    @JoinColumn(name = "clauseId", referencedColumnName = "clauseId")
    private Clause clause;
    @Column(name = "clauseId", nullable = false, insertable = false, updatable = false)
    private Integer clauseId;
    
    @Column(name = "isValid", nullable = false)
    private boolean isValid;
    
    @Column(name = "isModified", nullable = false)
    private boolean isModified;
    
    @Column(name = "status", nullable = false, length = 45)
    private String status;
}

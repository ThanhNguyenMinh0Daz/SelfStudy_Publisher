package com.publisher.modules.storage.entities;

import com.publisher.modules.customerAndContract.entities.Contract;
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
@Table (name = "contract_item_list")
public class ContractItemList {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pairId", nullable = false)
    private Integer pairId;

    @ManyToOne
    @JoinColumn(name = "contractId", referencedColumnName = "contractId")
    private Contract contract;
    @Column(name = "contractId", nullable = false, insertable = false, updatable = false)
    private Integer contractId;

    @ManyToOne
    @JoinColumn(name = "itemId", referencedColumnName = "itemId")
    private Item item;
    @Column(name = "itemId", nullable = false, insertable = false, updatable = false)
    private Integer itemId;
    
    @Column(name = "relation", nullable = true, length = 45)
    private String relation;
}

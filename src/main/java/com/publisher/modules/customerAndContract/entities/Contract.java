package com.publisher.modules.customerAndContract.entities;

import com.publisher.modules.planAndTask.entities.ContractPlanList;
import com.publisher.modules.storage.entities.ContractItemList;
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
@Table (name = "contract")
public class Contract {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "contractId", nullable = false)
    private Integer contractId;
    
    @Column(name = "contractCode", nullable = true, length = 45)
    private String contractCode;
    
    @Column(name = "contractName", nullable = true, length = 45)
    private String contractName;
    
    @Column(name = "contractType", nullable = true, length = 45)
    private String contractType;
    
    @Column(name = "contractDate", nullable = true)
    private Timestamp contractDate;

    @OneToMany(mappedBy = "contract")
    private List<ContractComposition> contractComposition;

    @OneToMany(mappedBy = "contract")
    private List<ContractParticipant> contractParticipantList;

    @OneToMany(mappedBy = "contract")
    private List<ContractPlanList> contractPlanList;

    @OneToMany(mappedBy = "contract")
    private List<ContractItemList> contractItemLists;
}

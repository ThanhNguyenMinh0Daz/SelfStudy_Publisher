package com.publisher.modules.planAndTask.entities;

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
@Table(name = "contract_plan_list")
public class ContractPlanList {
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
    @JoinColumn(name = "planId", referencedColumnName = "planId")
    private Plan plan;
    @Column(name = "planId", nullable = false, insertable = false, updatable = false)
    private Integer planId;
}

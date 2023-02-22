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
@Table (name = "modified_clause")
@PrimaryKeyJoinColumn(name = "modifiedClauseId", referencedColumnName = "clauseId")
public class ModifiedClause extends Clause {
    @OneToOne
    @MapsId
    @JoinColumn(name = "modifiedClauseId", referencedColumnName = "clauseId")
    private Clause clause;
    @Column(name = "modifiedClauseId", nullable = false, insertable = false, updatable = false)
    private Integer modifiedClauseId;

    @ManyToOne
    @JoinColumn(name = "standardClauseId", referencedColumnName = "standardClauseId")
    private StandardClause standardClause;
    @Column(name = "standardClauseId", nullable = false, insertable = false, updatable = false)
    private Integer standardClauseId;
    
    @Column(name = "modifiedType", nullable = false, length = 45)
    private String modifiedType;
    
    @Column(name = "modifyReason", nullable = true, length = -1)
    private String modifyReason;
}

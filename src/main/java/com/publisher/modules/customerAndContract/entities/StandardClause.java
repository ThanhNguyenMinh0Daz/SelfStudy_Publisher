package com.publisher.modules.customerAndContract.entities;

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
@Table (name = "standard_clause")
@PrimaryKeyJoinColumn(name = "standardClauseId", referencedColumnName = "clauseId")
public class StandardClause extends Clause {
    @OneToOne
    @MapsId
    @JoinColumn(name = "standardClauseId", referencedColumnName = "clauseId")
    private Clause clause;
    @Column(name = "standardClauseId", nullable = false, insertable = false, updatable = false)
    private Integer standardClauseId;


    @OneToMany(mappedBy = "standardClause")
    private List<ModifiedClause> modifiedClauseList;
}

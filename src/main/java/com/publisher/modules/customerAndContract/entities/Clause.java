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
@Table (name = "clause")
@Inheritance(strategy = InheritanceType.JOINED)
public class Clause {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "clauseId", nullable = false)
    private Integer clauseId;
    
    @Column(name = "parentClauseId", nullable = true)
    private Integer parentClauseId;
    
    @Column(name = "clauseName", nullable = false, length = 45)
    private String clauseName;
    
    @Column(name = "clauseContent", nullable = false, length = -1)
    private String clauseContent;
    
    @Column(name = "clauseType", nullable = false, length = 45)
    private String clauseType;
    
    @Column(name = "status", nullable = false, length = 45)
    private String status;
}

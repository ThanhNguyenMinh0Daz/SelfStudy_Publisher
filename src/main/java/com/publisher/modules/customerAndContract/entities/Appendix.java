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
@Table (name = "appendix")
@PrimaryKeyJoinColumn(name = "appendixId", referencedColumnName = "clauseId")
public class Appendix extends Clause {
    @OneToOne
    @MapsId
    @JoinColumn(name = "appendixId", referencedColumnName = "clauseId")
    private Clause clause;
    @Column(name = "appendixId", nullable = false, insertable = false, updatable = false)
    private Integer appendixId;
    
    @Column(name = "appendixType", nullable = false, length = 45)
    private String appendixType;

}

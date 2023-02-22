package com.publisher.modules.common.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "other_identifier")
public class OtherIdentifier {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "otherIdentifierId", nullable = false)
    private Integer otherIdentifierId;

    @ManyToOne
    @JoinColumn(name = "identifierId", referencedColumnName = "identifierId")
    private CommonIdentifier commonIdentifier;
    @Column(name = "identifierId", nullable = false, insertable = false, updatable = false)
    private Integer identifierId;
    
    @Column(name = "otherIdentifierType", nullable = false, length = 45)
    private String otherIdentifierType;
    
    @Column(name = "value", nullable = false, length = -1)
    private String value;
    
    @Column(name = "validFrom", nullable = false)
    private Timestamp validFrom;
    
    @Column(name = "validTo", nullable = true)
    private Timestamp validTo;

}

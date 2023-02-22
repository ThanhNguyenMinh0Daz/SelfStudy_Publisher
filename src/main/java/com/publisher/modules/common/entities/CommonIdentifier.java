package com.publisher.modules.common.entities;

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
@Table (name = "common_identifier")
public class CommonIdentifier {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "identifierId", nullable = false)
    private Integer identifierId;
    
    @Column(name = "fullName", nullable = false, length = 450)
    private String fullName;
    
    @Column(name = "alias", nullable = true, length = 45)
    private String alias;

    @OneToMany(mappedBy = "commonIdentifier")
    private List<OtherIdentifier> otherIdentifierList;
}

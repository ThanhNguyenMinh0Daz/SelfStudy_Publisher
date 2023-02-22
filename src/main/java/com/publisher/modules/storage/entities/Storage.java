package com.publisher.modules.storage.entities;

import com.publisher.modules.common.entities.CommonIdentifier;
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
@Table(name = "storage")
public class Storage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "storageId", nullable = false)
    private Integer storageId;

    @OneToOne
    @JoinColumn(name = "identifierId", referencedColumnName = "identifierId")
    private CommonIdentifier commonIdentifier;
    @Column(name = "identifierId", nullable = false, insertable = false, updatable = false)
    private Integer identifierId;
    
    @Column(name = "storageCode", nullable = false, length = 45)
    private String storageCode;
    
    @Column(name = "storageType", nullable = false, length = 45)
    private String storageType;
    
    @Column(name = "storageSize", nullable = false, precision = 0)
    private double storageSize;


    @OneToMany(mappedBy = "storage")
    private List<StorageUnit> storageUnitList;
}

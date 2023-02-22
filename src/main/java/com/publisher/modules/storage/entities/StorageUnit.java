package com.publisher.modules.storage.entities;

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
@Table(name = "storage_unit")
public class StorageUnit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "storageUnitId", nullable = false)
    private Integer storageUnitId;

    @ManyToOne
    @JoinColumn(name = "storageId", referencedColumnName = "storageId")
    private Storage storage;
    @Column(name = "storageId", nullable = false, insertable = false, updatable = false)
    private Integer storageId;
    
    @Column(name = "unitCode", nullable = false, length = 45)
    private String unitCode;
    
    @Column(name = "unitSize", nullable = false, precision = 0)
    private double unitSize;
    
    @Column(name = "unitType", nullable = false, length = 45)
    private String unitType;
    
    @Column(name = "unitPosition", nullable = false, length = 45)
    private String unitPosition;

    @OneToMany(mappedBy = "storageUnit")
    private List<ItemInventory> itemInventoryList;
}

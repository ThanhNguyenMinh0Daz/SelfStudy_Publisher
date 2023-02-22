package com.publisher.modules.storage.entities;

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
@Table(name = "item_inventory")
public class ItemInventory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "inventoryId", nullable = false)
    private Integer inventoryId;

    @ManyToOne
    @JoinColumn(name = "storageUnitId", referencedColumnName = "storageUnitId")
    private StorageUnit storageUnit;
    @Column(name = "storageUnitId", nullable = false, insertable = false, updatable = false)
    private Integer storageUnitId;

    @ManyToOne
    @JoinColumn(name = "itemId", referencedColumnName = "itemId")
    private Item item;
    @Column(name = "itemId", nullable = false, insertable = false, updatable = false)
    private Integer itemId;
    
    @Column(name = "inventoryAt", nullable = false)
    private Timestamp inventoryAt;
    
    @Column(name = "increase", nullable = true, precision = 0)
    private Double increase;
    
    @Column(name = "decrease", nullable = true, precision = 0)
    private Double decrease;
}

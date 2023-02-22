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
@Table(name = "item")
public class Item {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "itemId", nullable = false)
    private Integer itemId;
    
    @Column(name = "itemCode", nullable = true, length = 45)
    private String itemCode;
    
    @Column(name = "itemName", nullable = true, length = 45)
    private String itemName;
    
    @Column(name = "itemType", nullable = true, length = 45)
    private String itemType;
    
    @Column(name = "countUnit", nullable = true, length = 45)
    private String countUnit;
    
    @Column(name = "listPrice", nullable = true, precision = 0)
    private Double listPrice;
    
    @Column(name = "currency", nullable = true, length = 45)
    private String currency;

    @OneToOne
    @JoinColumn(name = "identifierId", referencedColumnName = "identifierId")
    private CommonIdentifier commonIdentifier;
    @Column(name = "identifierId", nullable = false, insertable = false, updatable = false)
    private Integer identifierId;

    @OneToMany(mappedBy = "item")
    private List<ItemInventory> itemInventoryList;

    @OneToMany(mappedBy = "item")
    private List<ContractItemList> contractItemList;
}

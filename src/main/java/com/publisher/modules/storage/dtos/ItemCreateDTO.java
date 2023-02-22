package com.publisher.modules.storage.dtos;

import com.publisher.modules.common.dtos.commonIdentifier.CommonIdentifierCreateDTO;
import com.publisher.modules.storage.entities.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link Item} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemCreateDTO implements Serializable {
    private String itemCode;
    private String itemName;
    private String itemType;
    private String countUnit;
    private Double listPrice;
    private String currency;
    private CommonIdentifierCreateDTO commonIdentifier;
}
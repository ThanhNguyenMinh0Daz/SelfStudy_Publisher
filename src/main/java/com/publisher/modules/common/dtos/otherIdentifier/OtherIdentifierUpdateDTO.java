package com.publisher.modules.common.dtos.otherIdentifier;

import com.publisher.modules.common.entities.OtherIdentifier;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * A DTO for the {@link OtherIdentifier} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OtherIdentifierUpdateDTO implements Serializable {
    private Integer otherIdentifierId;
    private Integer identifierId;
    private String otherIdentifierType;
    private String value;
    private Timestamp validFrom;
    private Timestamp validTo;
}
package com.publisher.modules.common.dtos.otherIdentifier;

import com.publisher.modules.common.entities.OtherIdentifier;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link OtherIdentifier} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OtherIdentifierCreateDTO implements Serializable {
    private Integer identifierId;
    private String otherIdentifierType;
    private String value;
    private Timestamp validFrom = Timestamp.valueOf(LocalDateTime.now());
    private Timestamp validTo;
}
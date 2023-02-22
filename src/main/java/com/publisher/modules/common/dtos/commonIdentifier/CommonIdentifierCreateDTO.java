package com.publisher.modules.common.dtos.commonIdentifier;

import com.publisher.modules.common.dtos.otherIdentifier.OtherIdentifierCreateDTO;
import com.publisher.modules.common.entities.CommonIdentifier;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link CommonIdentifier} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommonIdentifierCreateDTO implements Serializable {
    private String fullName;
    private String alias;
    private List<OtherIdentifierCreateDTO> otherIdentifierList;
}
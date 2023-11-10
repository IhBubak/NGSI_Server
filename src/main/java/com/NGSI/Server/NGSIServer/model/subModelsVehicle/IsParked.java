package com.NGSI.Server.NGSIServer.model.subModelsVehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@Builder
public class IsParked {
    private String type;
    private String object;
    private String observedAt;
    private ProvidedBy providedBy;
}

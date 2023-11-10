package com.NGSI.Server.NGSIServer.model.subModelsParking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class AvailableSpotNumber {
    private Double value;
    private String observedAt;
    private Double reliability;
    private ProvidedBy providedBy;
}

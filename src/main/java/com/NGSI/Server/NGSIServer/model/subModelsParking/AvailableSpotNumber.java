package com.NGSI.Server.NGSIServer.model.subModelsParking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AvailableSpotNumber {
    private Double value;
    private String observedAt;
    private Double reliability;
    private ProvidedBy providedBy;
}

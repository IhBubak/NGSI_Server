package com.NGSI.Server.NGSIServer.model.subModelsVehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BrandName {
    private String type;
    private String value;
}

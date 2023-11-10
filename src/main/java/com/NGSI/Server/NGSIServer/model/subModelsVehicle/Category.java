package com.NGSI.Server.NGSIServer.model.subModelsVehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder

public class Category {
    private String type;
    private String vocab;
}

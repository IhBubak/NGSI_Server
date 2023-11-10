package com.NGSI.Server.NGSIServer.model.subModelsParking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Geometry {
    private String type;
    private List<Double> coordinates;
}

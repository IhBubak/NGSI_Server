package com.NGSI.Server.NGSIServer.model.subModelsParking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Geometry {
    private String type;
    private List<Double> coordinates;
}

package com.NGSI.Server.NGSIServer.model.subModelsParking;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Properties {
    private String type;
    private String name;
    private AvailableSpotNumber availableSpotNumber;
    private Geometry location;
    private Double totalSpotNumber;
    @JsonProperty("@context")
    private List<String> context;
}

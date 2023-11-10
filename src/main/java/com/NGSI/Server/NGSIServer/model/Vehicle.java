package com.NGSI.Server.NGSIServer.model;

import com.NGSI.Server.NGSIServer.model.subModelsVehicle.BrandName;
import com.NGSI.Server.NGSIServer.model.subModelsVehicle.Category;
import com.NGSI.Server.NGSIServer.model.subModelsVehicle.IsParked;
import com.NGSI.Server.NGSIServer.model.subModelsVehicle.Street;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@Builder
public class Vehicle {
    @Id
    private String id;
    private String type;
    private BrandName brandName;
    private Street street;
    private IsParked isParked;
    private Category category;
     @JsonProperty("@context")
     private List<String> context;

}

package com.NGSI.Server.NGSIServer.model;

import com.NGSI.Server.NGSIServer.model.subModelsParking.Geometry;
import com.NGSI.Server.NGSIServer.model.subModelsParking.Properties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Parking {
    @Id
    private String id;
    private String type;
    private Geometry geometry;
    private Properties properties;
}

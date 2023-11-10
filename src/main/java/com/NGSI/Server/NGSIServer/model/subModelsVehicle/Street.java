package com.NGSI.Server.NGSIServer.model.subModelsVehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Street {
    private String type;
    private LanguageMap languageMap;
}

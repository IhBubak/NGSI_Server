package com.NGSI.Server.NGSIServer.model.subModelsParking;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProvidedBy {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String additionalAttribute = "default value";
    private String object;

}

package com.NGSI.Server.NGSIServer.model.subModelsVehicle;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LanguageMap {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String fr;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String nl;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String en;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String es;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String de;
}

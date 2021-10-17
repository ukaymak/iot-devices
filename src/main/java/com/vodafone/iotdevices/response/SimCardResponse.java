package com.vodafone.iotdevices.response;

import com.vodafone.iotdevices.enums.SimCardStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimCardResponse {

    private Long simID;
    private Long operatorCode;
    private String countryName;
    private SimCardStatusEnum simCardStatus;

}



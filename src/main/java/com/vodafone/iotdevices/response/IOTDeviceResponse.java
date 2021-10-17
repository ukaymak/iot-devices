package com.vodafone.iotdevices.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IOTDeviceResponse {

    private Long id;
    private Boolean isConfigurated;
    private Long temperature;
    private SimCardResponse simCard;
}

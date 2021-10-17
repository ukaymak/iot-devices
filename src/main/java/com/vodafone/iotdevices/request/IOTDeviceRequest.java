package com.vodafone.iotdevices.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IOTDeviceRequest {

    private Long id;
    private Long temperature;
    private SimCardRequest simCard;
}

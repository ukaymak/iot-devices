package com.vodafone.iotdevices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IOTDeviceDto {

    private Long id;
    private Boolean isConfigurated;
    private Long temperature;
    private SimCardDto simCard;
}

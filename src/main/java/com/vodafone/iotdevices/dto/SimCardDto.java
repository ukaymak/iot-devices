package com.vodafone.iotdevices.dto;

import com.vodafone.iotdevices.enums.SimCardStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimCardDto {

    private Long simID;
    private Long operatorCode;
    private String countryName;
    private SimCardStatusEnum simCardStatus;
    private IOTDeviceDto iotDevice;
}

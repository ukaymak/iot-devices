package com.vodafone.iotdevices.service;

import com.vodafone.iotdevices.dbmodel.IOTDevice;
import com.vodafone.iotdevices.dbmodel.SimCard;
import com.vodafone.iotdevices.dto.IOTDeviceDto;
import com.vodafone.iotdevices.dto.SimCardDto;
import com.vodafone.iotdevices.enums.SimCardStatusEnum;
import com.vodafone.iotdevices.repository.IOTDeviceRepository;
import com.vodafone.iotdevices.repository.SimCardRepository;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IOTDeviceServiceTest {

    @InjectMocks
    @Spy
    private IOTDeviceService iotDeviceService;

    @Mock
    private IOTDeviceRepository iotDeviceRepository;

    @Mock
    private SimCardRepository simCardRepository;

    @Mock
    private DozerBeanMapper dozerBeanMapper;

    private IOTDevice iotDevice;
    private IOTDeviceDto iotDeviceDto;

    private SimCard simCard;
    private SimCardDto simCardDto;

    @Before
    public void init() {

        simCard = SimCard.builder()
                .simID(1L)
                .operatorCode(555L)
                .countryName("ENGLAND")
                .simCardStatus(SimCardStatusEnum.READY)
                .build();

        simCardDto = SimCardDto.builder()
                .simID(simCard.getSimID())
                .operatorCode(simCard.getOperatorCode())
                .countryName(simCard.getCountryName())
                .simCardStatus(simCard.getSimCardStatus())
                .build();

        iotDevice = IOTDevice.builder()
                .id(2L)
                .temperature(50L)
                .simCard(simCard)
                .build();

        iotDeviceDto = IOTDeviceDto.builder()
                .id(iotDevice.getId())
                .isConfigurated(iotDevice.getIsConfigurated())
                .temperature(iotDevice.getTemperature())
                .simCard(simCardDto)
                .build();

        when(dozerBeanMapper.map(any(SimCardDto.class), any())).thenReturn(simCard);
        when(simCardRepository.save(any())).thenReturn(simCard);

        when(dozerBeanMapper.map(any(IOTDeviceDto.class), any())).thenReturn(iotDevice);
        when(iotDeviceRepository.save(any())).thenReturn(iotDevice);

        when(dozerBeanMapper.map(any(IOTDevice.class), any())).thenReturn(iotDeviceDto);

    }

    @Test
    public void createDevice() {

        IOTDeviceDto iotDeviceDtoReturned = iotDeviceService.createDevice(iotDeviceDto);
        assertEquals(Optional.of(2L),Optional.ofNullable(iotDeviceDtoReturned.getId()));
        assertEquals(Optional.of(50L),Optional.ofNullable(iotDeviceDtoReturned.getTemperature()));
        assertEquals("ENGLAND",iotDeviceDtoReturned.getSimCard().getCountryName());
        assertEquals(SimCardStatusEnum.READY,iotDeviceDtoReturned.getSimCard().getSimCardStatus());

    }


}
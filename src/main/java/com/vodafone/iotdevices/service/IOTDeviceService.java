package com.vodafone.iotdevices.service;

import com.vodafone.iotdevices.dbmodel.IOTDevice;
import com.vodafone.iotdevices.dbmodel.SimCard;
import com.vodafone.iotdevices.dto.IOTDeviceDto;
import com.vodafone.iotdevices.dto.SimCardDto;
import com.vodafone.iotdevices.enums.SimCardStatusEnum;
import com.vodafone.iotdevices.exception.DeviceNotFoundException;
import com.vodafone.iotdevices.repository.IOTDeviceRepository;
import com.vodafone.iotdevices.repository.SimCardRepository;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IOTDeviceService {

    private final IOTDeviceRepository deviceRepository;

    private final SimCardRepository cardRepository;

    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();


    public IOTDeviceDto createDevice(IOTDeviceDto iotDeviceDto) {

        iotDeviceDto.setIsConfigurated(isConfiguratedDevice(iotDeviceDto));

        SimCardDto simCardDto = iotDeviceDto.getSimCard();
        SimCard simCard = cardRepository.save(dozerBeanMapper.map(simCardDto, SimCard.class));

        IOTDevice iotDevice = dozerBeanMapper.map(iotDeviceDto, IOTDevice.class);
        iotDevice.setSimCard(simCard);
        return dozerBeanMapper.map(deviceRepository.save(iotDevice), IOTDeviceDto.class);
    }


    public List<IOTDeviceDto> getAllDevice() {

        List<IOTDevice> iotDeviceList = deviceRepository.findByOrderByIsConfiguratedDesc();

        return iotDeviceList.stream().map(device ->
                        dozerBeanMapper.map(device, IOTDeviceDto.class))
                .collect(Collectors.toList());
    }


    public void deleteDevice(Long id) {

        if (!deviceRepository.existsById(id)) {
            throw new DeviceNotFoundException("Device not found!");
        }
        deviceRepository.deleteById(id);
    }

    public IOTDeviceDto updateDevice(IOTDeviceDto iotDeviceDto) {

        if (!deviceRepository.existsById(iotDeviceDto.getId())) {
            throw new DeviceNotFoundException("Device not found!");
        }

        iotDeviceDto.setIsConfigurated(isConfiguratedDevice(iotDeviceDto));
        IOTDevice iotDevice = deviceRepository.save(dozerBeanMapper.map(iotDeviceDto,IOTDevice.class));
        return dozerBeanMapper.map(iotDevice, IOTDeviceDto.class);
    }

    public List<IOTDeviceDto> getByStatus(SimCardStatusEnum simCardStatusEnum) {

        List<SimCard> simCardList = cardRepository.findAllBySimCardStatus(simCardStatusEnum);
        List<IOTDevice> iotDeviceList = simCardList.stream().map(SimCard::getIotDevice).collect(Collectors.toList());
        return iotDeviceList.stream().map(iotDevice ->
                        dozerBeanMapper.map(iotDevice, IOTDeviceDto.class))
                .collect(Collectors.toList());
    }

    public boolean isConfiguratedDevice(IOTDeviceDto iotDeviceDto) {
       return iotDeviceDto.getSimCard().getSimCardStatus().equals(SimCardStatusEnum.READY) &&
               (iotDeviceDto.getTemperature() > -25 && iotDeviceDto.getTemperature() < 85);
        }
}

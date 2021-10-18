package com.vodafone.iotdevices.controller;


import com.vodafone.iotdevices.dto.IOTDeviceDto;
import com.vodafone.iotdevices.enums.SimCardStatusEnum;
import com.vodafone.iotdevices.request.IOTDeviceRequest;
import com.vodafone.iotdevices.response.IOTDeviceResponse;
import com.vodafone.iotdevices.service.IOTDeviceService;
import org.dozer.DozerBeanMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/device")
public class IOTDeviceController {

    private final IOTDeviceService iotDeviceService;

    DozerBeanMapper dozerMapper = new DozerBeanMapper();

    public IOTDeviceController(IOTDeviceService iotDeviceService) {
        this.iotDeviceService = iotDeviceService;
    }


    @PostMapping
    public ResponseEntity<IOTDeviceResponse> createDevice(@RequestBody IOTDeviceRequest iotDeviceRequest){

        IOTDeviceDto deviceDto = iotDeviceService.createDevice(dozerMapper.map(iotDeviceRequest,IOTDeviceDto.class));
        return ResponseEntity.ok(dozerMapper.map(deviceDto,IOTDeviceResponse.class));

    }


    @GetMapping
    public ResponseEntity<List<IOTDeviceResponse>> getAllDevice() {

        List<IOTDeviceDto> deviceDtoList = iotDeviceService.getAllDevice();
        List<IOTDeviceResponse> iotDeviceResponseList = deviceDtoList.stream().map(device ->
                dozerMapper.map(device,IOTDeviceResponse.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(iotDeviceResponseList);

    }

    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable("id") Long id) {

         iotDeviceService.deleteDevice(id);
    }

    @PutMapping
    public ResponseEntity<IOTDeviceResponse> updateDevice(@RequestBody IOTDeviceRequest deviceRequest) {

        IOTDeviceDto deviceDto = iotDeviceService.updateDevice(dozerMapper.map(deviceRequest,IOTDeviceDto.class));
        return ResponseEntity.ok(dozerMapper.map(deviceDto,IOTDeviceResponse.class));

    }

    @GetMapping("/status")
    public ResponseEntity<List<IOTDeviceResponse>> getByStatus(@ModelAttribute("simCardStatus") SimCardStatusEnum simCardStatus){

        List<IOTDeviceDto> deviceDtoList = iotDeviceService.getByStatus(simCardStatus);
        List<IOTDeviceResponse> iotDeviceResponseList = deviceDtoList.stream().map(device ->
                        dozerMapper.map(device,IOTDeviceResponse.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(iotDeviceResponseList);
    }



}

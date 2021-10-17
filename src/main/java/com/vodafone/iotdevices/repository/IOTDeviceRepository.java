package com.vodafone.iotdevices.repository;

import com.vodafone.iotdevices.dbmodel.IOTDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOTDeviceRepository extends JpaRepository<IOTDevice,Long> {

    List<IOTDevice> findByOrderByIsConfiguratedDesc();

}

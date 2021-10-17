package com.vodafone.iotdevices.repository;

import com.vodafone.iotdevices.dbmodel.SimCard;
import com.vodafone.iotdevices.enums.SimCardStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimCardRepository extends JpaRepository<SimCard,Long> {

    List<SimCard> findAllBySimCardStatus(SimCardStatusEnum statusEnum);
}

package com.vodafone.iotdevices.dbmodel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vodafone.iotdevices.enums.SimCardStatusEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(schema = "pia",name= "sim_card")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimCard {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sim_id",nullable = false)
    private Long simID;

    @Column(name = "operator_code")
    private Long operatorCode;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private SimCardStatusEnum simCardStatus;

    @OneToOne(mappedBy = "simCard",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonBackReference
    private IOTDevice iotDevice;
}
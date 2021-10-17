package com.vodafone.iotdevices.dbmodel;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "pia",name= "iot_device")
public class IOTDevice {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "is_configurated")
    private Boolean isConfigurated;

    @Column(name = "temperature")
    private Long temperature;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sim_card_fk")
    @JsonManagedReference
    private SimCard simCard;
}
create schema pia;

alter schema pia owner to postgres;


create table pia.sim_card
(
    sim_id bigint not null
        constraint sim_card_pk
            primary key,
    operator_code bigint,
    country_name varchar,
    status varchar
);

alter table pia.sim_card owner to postgres;

create table pia.iot_device
(
    id bigint not null
        constraint iot_device_pk
            primary key,
    is_configurated boolean,
    temperature bigint,
    sim_card_fk bigint
        constraint iot_device_sim_card_sim_id_fk
            references pia.sim_card
);

alter table pia.iot_device owner to postgres;




INSERT INTO pia.sim_card (sim_id, operator_code, country_name, status) VALUES (24, 551, 'ENGLAND', 'READY');
INSERT INTO pia.sim_card (sim_id, operator_code, country_name, status) VALUES (26, 551, 'ENGLAND', 'WAITING_FOR_ACTIVATION');
INSERT INTO pia.sim_card (sim_id, operator_code, country_name, status) VALUES (28, 551, 'ENGLAND', 'WAITING_FOR_ACTIVATION');
INSERT INTO pia.sim_card (sim_id, operator_code, country_name, status) VALUES (30, 555, 'ENGLAND', 'READY');
INSERT INTO pia.sim_card (sim_id, operator_code, country_name, status) VALUES (32, 556, 'ENGLAND', 'READY');
INSERT INTO pia.sim_card (sim_id, operator_code, country_name, status) VALUES (22, 100, 'GERMANY', 'BLOCKED');

INSERT INTO pia.iot_device (id, is_configurated, temperature, sim_card_fk) VALUES (25, true, 26, 24);
INSERT INTO pia.iot_device (id, is_configurated, temperature, sim_card_fk) VALUES (27, false, 30, 26);
INSERT INTO pia.iot_device (id, is_configurated, temperature, sim_card_fk) VALUES (29, false, 800, 28);
INSERT INTO pia.iot_device (id, is_configurated, temperature, sim_card_fk) VALUES (31, true, 75, 30);
INSERT INTO pia.iot_device (id, is_configurated, temperature, sim_card_fk) VALUES (33, true, 45, 32);
INSERT INTO pia.iot_device (id, is_configurated, temperature, sim_card_fk) VALUES (23, true, 150, 22);
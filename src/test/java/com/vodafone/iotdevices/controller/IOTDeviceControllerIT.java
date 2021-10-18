package com.vodafone.iotdevices.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IOTDeviceControllerIT {

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @LocalServerPort
    private int port;

    @Test
    public void testGetAllDevices(){
        HttpEntity entity = new HttpEntity<>(null, headers);

        ResponseEntity responseEntity = testRestTemplate.exchange(createURLWithPort(
                "/device"), HttpMethod.GET, entity, String.class);

        assertNotNull(responseEntity.getBody());
        assertEquals(responseEntity.getStatusCode().value(),200);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
package com.arrowhead.demo.client.demo.controller;

import com.arrowhead.demo.client.demo.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class Controller {

    @Value("${client.name}")
    String clientName;
    @Value("${client.address}")
    String clientAddress;
    @Value("${client.port}")
    int port;
    @Value("${Arrowheadserver.address}")
    String serverAddress;
    @Value("${Arrowheadserver.port}")
    Integer serverPort;


    @GetMapping("/status")
    Device getStatus() {
        Device device = new Device(clientName, "running", clientAddress, port);
        return device;
    }
}

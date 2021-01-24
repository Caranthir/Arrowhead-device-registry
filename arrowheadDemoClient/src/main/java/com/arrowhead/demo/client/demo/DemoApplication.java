package com.arrowhead.demo.client.demo;

import com.arrowhead.demo.client.demo.model.Device;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {


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


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        RestTemplate restTemplate = new RestTemplate();

        Device device = new Device(clientName, "started", clientAddress, port);

        HttpEntity<Device> request = new HttpEntity<>(device);
        Device savedDevice = restTemplate.postForObject("http://"+serverAddress + ":"+ serverPort+"/device", request, Device.class);
        System.out.println(savedDevice);
    }
}

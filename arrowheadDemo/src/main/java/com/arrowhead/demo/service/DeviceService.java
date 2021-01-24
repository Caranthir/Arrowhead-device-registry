package com.arrowhead.demo.service;

import com.arrowhead.demo.model.Device;
import com.arrowhead.demo.repository.DeviceRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Service
public class DeviceService {
    RestTemplate restTemplate;
    DeviceRepository repository;

    public DeviceService(RestTemplate restTemplate, DeviceRepository repository) {
        this.restTemplate = restTemplate;
        this.repository = repository;
    }

    public List<Device> updateStatus(){
        List<Device> devices =  repository.findAll();
        devices.forEach(device -> {
            try {
                Device newDevice = restTemplate.getForObject("http://" + device.getAddress() + ":" + device.getPort() + "/status", Device.class);
                newDevice.setLast_notification_date(new Timestamp(Calendar.getInstance().getTimeInMillis()));
                repository.save(newDevice);
            }
            catch (RestClientException ex){
                System.out.println("catched ex\n " + ex.getMessage());
                repository.delete(device);
            }

        });
        return repository.findAll();
    }

}

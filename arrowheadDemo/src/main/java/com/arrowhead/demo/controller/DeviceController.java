package com.arrowhead.demo.controller;

import com.arrowhead.demo.model.Device;
import com.arrowhead.demo.repository.DeviceRepository;
import com.arrowhead.demo.service.DeviceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@RestController
public class DeviceController {

    private final DeviceRepository repository;
    private final DeviceService service;

    DeviceController(DeviceRepository repository, DeviceService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/device")
    List<Device> all() {
        //TODO this should also update the status of the devices. for this it should contact the devices.
        return service.updateStatus();
    }

    @PostMapping("/device")
    Device newDevice(@RequestBody Device newDevice) {
        newDevice.setLast_notification_date(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        return repository.save(newDevice);
    }

}

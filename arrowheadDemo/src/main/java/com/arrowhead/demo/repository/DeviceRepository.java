package com.arrowhead.demo.repository;

import com.arrowhead.demo.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, String> {

}
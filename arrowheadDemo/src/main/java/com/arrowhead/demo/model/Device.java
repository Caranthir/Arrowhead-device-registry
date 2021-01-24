package com.arrowhead.demo.model;

import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Device {

    @Id
    private String device_name;
    private Timestamp last_notification_date;
    private String status;
    private String address;
    private int port;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public Timestamp getLast_notification_date() {
        return last_notification_date;
    }

    public void setLast_notification_date(Timestamp last_notification_date) {
        this.last_notification_date = last_notification_date;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}



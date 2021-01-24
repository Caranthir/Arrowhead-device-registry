package com.arrowhead.demo.client.demo.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Device {

    private String device_name;
    private Timestamp last_notification_date;
    private String status;
    private String address;
    private int port;

    public Device() {
    }

    public Device(String device_name, String status, String address, int port) {
        this.device_name = device_name;
        this.status = status;
        this.address = address;
        this.port = port;
    }

    public Timestamp getLast_notification_date() {
        return last_notification_date;
    }

    public void setLast_notification_date(Timestamp last_notification_date) {
        this.last_notification_date = last_notification_date;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Device{" +
                "device_name='" + device_name + '\'' +
                ", last_notification_date=" + last_notification_date +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", port=" + port +
                '}';
    }
}



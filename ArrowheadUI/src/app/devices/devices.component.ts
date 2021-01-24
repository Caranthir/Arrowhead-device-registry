import {Component, OnInit} from '@angular/core';
import { Device, DevicesService } from './devices.service';

@Component({
  selector: 'app-devices',
  templateUrl: './devices.component.html',
  styleUrls: ['devices.css'],
  providers: [ DevicesService ]
})
export class DevicesComponent implements OnInit {
  devices: Device[];
  displayedColumns: string[] = ['deviceName', 'lastNotificationDate', 'status', 'address', 'port'];

  constructor(private devicesService: DevicesService){}

  ngOnInit() {
    this.showDevices();
  }

  showDevices() {
    this.devicesService.getDevices()
      .subscribe(devices => (this.devices = devices));
  }


}

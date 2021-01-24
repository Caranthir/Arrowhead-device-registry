import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

export interface Device {
  device_name: string;
  last_notification_date: string;
  status: string;
  address: string;
  port: bigint;
}

@Injectable()
export class DevicesService {
  serverUrl = 'http://localhost:8080/device';


  constructor(private http: HttpClient) { }

  getDevices() {
    return this.http.get<Device[]>(this.serverUrl);
  }
}

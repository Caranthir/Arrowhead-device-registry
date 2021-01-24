import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';




import { AppComponent } from './app.component';
import {DevicesComponent} from './devices/devices.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  imports: [
    BrowserModule,
    // import HttpClientModule after BrowserModule.
    HttpClientModule,
    MatTableModule,
    MatButtonModule,
    MatToolbarModule
  ],
  declarations: [
    AppComponent,
    DevicesComponent
  ],
  bootstrap: [ AppComponent ],
  exports: [MatTableModule,
    MatButtonModule,
    MatToolbarModule]
})
export class AppModule {}

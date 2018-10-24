import {Component, ElementRef, ViewChild} from '@angular/core';
import {Geolocation} from "@ionic-native/geolocation";
import { MouseEvent } from '@agm/core';
import {MenuController} from "ionic-angular";

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  // google maps zoom level
  zoom: number = 14;

  // initial center position for the map
  lat: number  = -0.181869;
  lng: number = -78.479024;

  map: any;

  constructor(private geolocation: Geolocation, public menuCtrl: MenuController) {
    //this.menuCtrl.enable(true);

  }

  ionViewWillEnter () {
    this.menuCtrl.enable (true);
  }

  markerDragEnd(m: marker, $event: MouseEvent) {
    console.log('dragEnd', m, $event);
  }

  clickedMarker(label: string, index: number) {
    console.log(`clicked the marker: ${label || index}`)
  }

  mapClicked($event: MouseEvent) {
    this.markers.push({
      lat: $event.coords.lat,
      lng: $event.coords.lng,
      draggable: true
    });
  }

  markers: marker[] = [
    {
      lat: -0.181869,
      lng: -78.479024,
      label: 'Av. Eloy Alfaro',
      draggable: false
    }
  ];

}

interface marker {
  lat: any;
  lng: any;
  label?: string;
  draggable: boolean;
}

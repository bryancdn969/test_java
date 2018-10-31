import {Component} from '@angular/core';
import { MouseEvent } from '@agm/core';
import {MenuController, NavController} from "ionic-angular";

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
  userData: any;

  constructor(public menuCtrl: MenuController, public navCtrl: NavController,) {
    //this.menuCtrl.enable(true);
    //this.responseData = localStorage.setItem('userData');
    this.userData = localStorage.getItem('userData');
    console.log("Array: " + JSON.parse(JSON.stringify(this.userData)));
    if (this.userData == null){
      console.log("Null");
    }
    else if(this.userData.principal == undefined){
      console.log("Undefined");
    }
    else if (this.userData.principal.role == "SADMIN" ) {
      console.log("Home: " + this.userData);
    }
  }

  ionViewWillEnter () {
    this.menuCtrl.enable (true);
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad Home page...');
    /*if (this.responseData.principal.role == "SADMIN") {
      this.navCtrl.setRoot(ListPage);
    }*/
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

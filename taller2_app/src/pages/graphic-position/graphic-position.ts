import {Component, ElementRef, ViewChild, Output, EventEmitter, OnInit, OnChanges, SimpleChange} from '@angular/core';
import {IonicPage, MenuController, NavController} from 'ionic-angular';
import {Geolocation} from "@ionic-native/geolocation";
import {MapProvider} from "../../providers/map/map";

declare var google;

@IonicPage()
@Component({
  selector: 'page-graphic-position',
  templateUrl: 'graphic-position.html',
})
export class GraphicPositionPage {

  @ViewChild('map') mapElement: ElementRef;
  map: any;
  start = 'chicago, il';
  end = 'chicago, il';
  directionsService = new google.maps.DirectionsService;
  directionsDisplay = new google.maps.DirectionsRenderer;
  address: any[];
  validationList: any;

  constructor(private geolocation: Geolocation, public menuCtrl: MenuController,
              private service: MapProvider) {
   // this.menuCtrl.enable(true);
  }

  ionViewDidLoad(){
    this.initMap();

    let pro = this.service.getAddress();
    Promise.resolve(pro).then(data => {
      this.validationList = JSON.parse(JSON.stringify(data)).response;
      console.log(this.validationList);
      this.address = this.validationList;
      console.log(this.address);
    });

  }

  ionViewWillEnter () {
    this.menuCtrl.enable (true);
  }

  initMap() {

    this.geolocation.getCurrentPosition().then((position) => {
    let latLng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);

    let mapOptions = {
      center: latLng,
      zoom: 18,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    this.map = new google.maps.Map(this.mapElement.nativeElement,mapOptions);

    this.directionsDisplay.setMap(this.map);

      let marker = new google.maps.Marker({
        map: this.map,
        animation: google.maps.Animation.DROP,
        position: this.map.getCenter()
      });

    });
  }

  calculateAndDisplayRoute() {
    this.directionsService.route({
      origin: this.start,
      destination: this.end,
      travelMode: 'DRIVING'
    }, (response, status) => {
      if (status === 'OK') {
        this.directionsDisplay.setDirections(response);
      } else {
        window.alert('Directions request failed due to ' + status);
      }
    });
  }


}

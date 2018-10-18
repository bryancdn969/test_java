import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {MapService} from '../map.service';


declare var google: any;

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})

export class UpdateComponent implements OnInit {

  @ViewChild('map') mapElement: ElementRef;
  map: any;
  start = 'Quito 170144';
  end = 'Av Pedro Vicente Maldonado, Quito 170111';
  directionsService = new google.maps.DirectionsService;
  directionsDisplay = new google.maps.DirectionsRenderer;
  public validationList: any;

  constructor(private service: MapService) {

  }
  ngOnInit() {
    this.initMap();

    let pro = this.service.getAddress();
    Promise.resolve(pro).then(data => {
      this.validationList = JSON.parse(JSON.stringify(data)).response;

      console.log(this.validationList);
    });

  }


  initMap() {

    // google maps zoom level
    let zoom: number = 8;

    // initial center position for the map
    let lat: number = 51.673858;
    let lng: number = 7.815982;


      let latLng = new google.maps.LatLng(lat, lng);

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

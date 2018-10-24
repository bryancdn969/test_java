import { Component } from '@angular/core';
import {IonicPage, MenuController, NavController, NavParams} from 'ionic-angular';

import {MapProvider} from "../../providers/map/map";

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {HomePage} from "../home/home";

@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {

  userData = {"userName":"","password":""};
  validationList: any;

  constructor(public navCtrl: NavController, public navParams: NavParams,
              public authService: MapProvider, private http: HttpClient,
              public menuCtrl: MenuController) {
    this.menuCtrl.enable(false, 'myMenu');
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad LoginPage');
  }


  ionViewWillEnter () {
    this.menuCtrl.enable (false);
  }


  login() {
    if(this.userData.userName && this.userData.password) {
      this.authService.postFormData(this.userData, "/access/login").then((result) => {
        this.validationList = JSON.stringify(result);
        console.log("Save " + this.validationList);
        let parse = JSON.parse(this.validationList);
        console.log("Save " + parse);
        if(parse.status == 'OK' ){
          localStorage.setItem('userData',this.validationList);
          console.log("Save OK");
          this.navCtrl.setRoot(HomePage);
        }
        else{
          console.log("Error when save");
        }
      }, (err) => {
        console.log("Error de result " + err);
      });
     /*let pro = this.authService.getLogin();
      Promise.resolve(pro).then(data => {
        this.validationList = JSON.parse(JSON.stringify(data)).response;
        console.log("result " +  this.validationList);
       // if(this.validationList.status == 'OK' ){
          localStorage.setItem('userData',JSON.stringify(this.validationList));
      //  }else{
         // console.log("Error save local storage")
       // }
      }, (err) => {
        console.log("Error data promise " +err);
        //this.common.closeLoading();
      });

     /* let url = 'http://localhost:8080/access/login';
      this.http.get<Observable<boolean>>(url).subscribe(isValid => {
        if (isValid) {
          sessionStorage.setItem('token', btoa(this.userData.userName + ':' + this.userData.password));
          console.log("Good..." + this.userData.userName + this.userData.password)
        } else {
          alert("Authentication failed.")
        }
      });*/
    }else{
      console.log("No hay Data")
    }
  }
}

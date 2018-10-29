import { Component } from '@angular/core';
import {IonicPage, MenuController, NavController, NavParams} from 'ionic-angular';

import {AuthServiceProvider} from "../../providers/auth-service/auth-service";

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {HomePage} from "../home/home";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {GraphicPositionPage} from "../graphic-position/graphic-position";
import {el} from "@angular/platform-browser/testing/src/browser_util";
import {ListPage} from "../list/list";

@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {

  userInfo: any = {};
  authForm: FormGroup;
  username: AbstractControl;
  password: AbstractControl;
  responseData : any;
  userData = {"role":"","id":""};

  constructor(public navCtrl: NavController, public navParams: NavParams,
              public authService: AuthServiceProvider,public formBuilder: FormBuilder,
              public menuCtrl: MenuController) {
    this.menuCtrl.enable(false, 'myMenu');
    localStorage.clear();
    this.authForm = formBuilder.group({
      email: ['', Validators.compose([Validators.required, Validators.email, Validators.minLength(8), Validators.maxLength(30)])],
      password: ['', Validators.compose([Validators.required, Validators.minLength(6)])]
    });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad LoginPage');
  }


  ionViewWillEnter () {
    this.menuCtrl.enable (false);
  }

  login(value: any) {
    let promise = this.authService.login(value.email, value.password).then((data) => {
        this.responseData = data;
        console.log(this.responseData);
        if(this.responseData.principal.role == "USER" ){
          localStorage.setItem('userData',JSON.stringify(this.responseData));
          this.navCtrl.setRoot(GraphicPositionPage);
        }
        else if (this.responseData.principal.role == "SADMIN"){
          localStorage.setItem('userData',JSON.stringify(this.responseData));
          this.navCtrl.setRoot(HomePage, ListPage);
        } else{
          console.log("Nothig permisson");
      }

      });
  }
}

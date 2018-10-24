import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import {map} from "rxjs/operators";
import {Observable} from "rxjs";

let apiUrl = 'http://localhost:8080';

@Injectable()
export class MapProvider {

  headers: any;
  options: any;
  
  constructor(public http: Http) {
    console.log('Hello MapProvider Provider');
    this.http = http;
    this.headers = new Headers({ 'Content-Type': 'application/json' });
    
  }

  getAddress() {
    return this.callGetService('/map/', 'getAddress');
  }

  getLogin(){
    return this.logIn('/access/login','getLogin')
  }

  private callGetService(url: string, method: any) {
    let headers = new Headers();
    return new Promise((resolve, reject) => {
      this.http.get(apiUrl + url, {headers: headers}).toPromise()
        .then(res => resolve(res.json()),
          err => {
            console.log("callGetService =>" + method, err);
          });
    });
  }

  private logIn(url: string, method: any) {
    let headers = new Headers();
    return new Promise((resolve, reject) => {
      this.http.get(apiUrl + url, {headers: headers})
        .subscribe(isValid => {
          resolve(isValid.json());
          if (isValid) {
            console.log("Good...");
          } else {
            console.log("Authentication failed."+ method);
          }
      }, (err) =>{
          reject(err);
        });
    });

  }

  postFormData(formData, type){
    var form_data = new FormData();
    for ( var key in formData ) {
      form_data.append(key, formData[key]);
    }
    return new Promise((resolve, reject) =>{
      let headers = new Headers();
      this.http.get(apiUrl+type, {headers: headers}).
      subscribe(res =>{
        resolve(res.json());
        if (res) {
          console.log("Good...");
        } else {
          console.log("Authentication failed.");
        }
      }, (err) =>{
        reject(err);
      });
    });

  }

}

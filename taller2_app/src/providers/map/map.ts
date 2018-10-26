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

  private callGetService(url: string, method: any) {
    let headers = new Headers();
    return new Promise((resolve, reject) => {
      this.http.get(apiUrl + url, {headers: headers}).
      toPromise()
        .then(res => resolve(res.json()),
          err => {
            console.log("callGetService =>" + method, err);
          });
    });
  }

}

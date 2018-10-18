import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import {AppComponent} from './app.component';

let apiUrl = 'http://192.168.1.22:8080';

@Injectable({
  providedIn: 'root'
})
export class MapService {

  headers: any;
  options: any;


  constructor(private http: Http) {
    this.headers = new Headers({ 'Content-Type': 'application/json' });
    this.options = new RequestOptions({ headers: this.headers });
  }

  getAddress() {
    return this.callGetService('/map/', 'getAddress');
  }

  private callGetService(url: string, method: any) {
    return new Promise((resolve, reject) => {
      this.http.get(apiUrl + url, this.options).toPromise()
        .then(res => resolve(res.json()),
          err => {
            console.log("callGetService =>" + method, err);
          });
    });
  }
}

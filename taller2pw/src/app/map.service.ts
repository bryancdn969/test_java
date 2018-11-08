import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import {AppComponent} from './app.component';

let apiUrl = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class MapService {

  constructor(private http: Http) {
    this.http = http;
  }
  
  getAddress() {
    return this.callGetService('/map/', 'getAddress');
  }

  getGender(id: any){
    return this.callGetService('/api/get/gender?id=' + id, 'getCatalogGender(id: any)');
  }

  getFrom(id: any){
    return this.callGetService('/api/get/from?id=' + id, 'getCatalogFrom(id: any)');
  }

  private callGetService(url: string, method: any) {
    let headers = new Headers();
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('Access-Control-Allow-Headers',  'Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With');
    headers.append('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, OPTIONS');
    headers.append('Access-Control-Allow-Credentials',  'true');
    return new Promise((resolve, reject) => {
      this.http.get(apiUrl + url, {headers: headers}).toPromise()
        .then(res => resolve(res.json()),
          err => {
            console.log("callGetService =>" + method, err);
          });
    });
  }
}

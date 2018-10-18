import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';

let apiUrl = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  /*headers: Headers;
  options: RequestOptions;

  constructor(private http: Http) {
    this.headers = new Headers({ 'Content-Type': 'application/json' });
    this.options = new RequestOptions({ headers: this.headers });
  }

  registerUsers(formData, type)  {
    var form_data = new FormData();
    for ( var key in formData ) {
      form_data.append(key, formData[key]);
    }
    return new Promise((resolve, reject) => {
      this.http.post(apiUrl + type, form_data, this.options).
        subscribe(res => {
        resolve(res.json());
      }, (err) => {
            console.log('callGetService =>' + reject(err));
          });
    });
  }
*/
}

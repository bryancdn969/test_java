import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions} from '@angular/http';

let apiUrl = 'http://localhost:8080';

@Injectable()
export class AuthServiceProvider {

  constructor(public http: Http) {
    console.log('Hello AuthServiceProvider Provider');
  }

  login(email, password) {
    // creating base64 encoded String from user name and password
    let headers = new Headers();
    headers.append('Accept', 'application/json')
    var base64Credential: string = btoa(email + ':' + password);
    headers.append("Authorization", "Basic " + base64Credential);
    let options = new RequestOptions();
    options.headers = headers;

    return new Promise((resolve, reject) => {
      this.http.get(apiUrl + "/account/login/", options).subscribe(res =>{
        resolve(res.json());
      }, (err) =>{
        reject(err);
      });
    });
  }

}

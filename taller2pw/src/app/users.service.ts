import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, Response} from '@angular/http';
import {User} from './model/model.user';
import 'rxjs/add/operator/map';
import {Router} from '@angular/router';
import {Person} from './model/model.person';

let apiUrl = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  constructor(public http: Http, private router: Router) { }

  public logIn(user: User){

    let headers = new Headers();
    headers.append('Accept', 'application/json');
    // creating base64 encoded String from user name and password
    let base64Credential: string = btoa( user.username+ ':' + user.password);
    headers.append("Authorization", "Basic " + base64Credential);

    let options = new RequestOptions();
    options.headers=headers;

    return new Promise((resolve, reject) =>{
    this.http.get(apiUrl+'/account/login',   options)
      .subscribe(res => {
        resolve(res.json());
        // login successful if there's a jwt token in the response
        let user = res.json().principal;// the returned user object is a principal object
        if (user) {
          // store user details  in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify(user));
          console.log("Data: " + JSON.stringify(user.role));
          //if(JSON.stringify(user.role) == "SADMIN"){
           // this.router.navigate(['/Trace a route']);
         // }else if(JSON.stringify(user.role) == "USER"){
          //  this.router.navigate(['/nav']);
         // }

        }
      });
    });
  }

  logOut() {
    // remove user from local storage to log user out
    return this.http.post(apiUrl+"logout",{})
      .map((response: Response) => {
        localStorage.removeItem('currentUser');
      });

  }

  createAccount(user:User){
    return this.http.post(apiUrl+'/account/register',user)
      .map(resp=>
        resp.json());
  }

  createAccountPerson(person:Person){
    return this.http.post(apiUrl+'/api/register',person)
      .map(resp=>
        resp.json());
  }

}

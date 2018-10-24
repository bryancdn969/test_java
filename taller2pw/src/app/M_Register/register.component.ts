import { Component, OnInit } from '@angular/core';
import {UsersService} from '../users.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private userService: UsersService) {
  }
  ngOnInit() {
  }
  /*
    userData = {"name": "", "ci": "", "phone": "", "direction": ""};
    responseData: any;
    UsersRegister: registerUser= new registerUser();





    RUsers() {
      this.userService.registerUsers(this.userData,'/users/M_Register').then((result) => {
        this.responseData = result;
        console.log(this.responseData);
        //if (this.responseData.status == 1) {
          localStorage.setItem('userData', JSON.stringify(this.responseData));
        //}
       // else {
          console.log("error" + this.responseData);
        //}
      }, (err) => {
        console.log(err);
      });
      this.UsersRegister = new registerUser();
  /*
      this.userService.registerUsers(this.UsersRegister).then((result) => {
        this.responseData = result;
        console.log(this.responseData);
        if (this.responseData.status == 1) {
          localStorage.setItem('userData', JSON.stringify(this.responseData));
        }
        else {
          console.log("error" + this.responseData);
        }
      }, (err) => {
        console.log(err);
      });

  }*/
}

import { Component, OnInit } from '@angular/core';
import {UsersService} from "../users.service";
import {Router} from '@angular/router';
import {User} from "../model/model.user";
import {SearchComponent} from '../M_MarkCircle/search.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User=new User();
  errorMessage:string;
  responseData : any;

  constructor(private authService :UsersService, private router: Router) { }

  ngOnInit() {
  }

    login(key: string){
      this.authService.logIn(this.user)
        .then((data) => {
          this.responseData = data;
          console.log(JSON.stringify(this.responseData));
          if(this.responseData.principal.role == "USER" ){
            localStorage.setItem('userData',JSON.stringify(this.responseData));
            this.router.navigate(['/Mark a circle']);
          }
          else if (this.responseData.principal.role == "SADMIN"){
            localStorage.setItem('userData',JSON.stringify(this.responseData));
            this.router.navigate(['/nav']);
          } else{
            console.log("Nothig permisson");
          }
            //this.router.navigate(['/nav']);
          },err=>{
            this.errorMessage="error :  Username or password is incorrect";
          }
        )
    }

}

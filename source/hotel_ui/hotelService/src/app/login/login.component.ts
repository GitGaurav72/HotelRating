import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule, NgModel } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login',
  standalone: true,
  imports:[RouterLink,FormsModule],  
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
 

  userName: string ="";
  password: string ="";


  constructor(private router: Router,private http: HttpClient) {}
  Login()
  {
  
    let bodyData = {
      "userName" : this.userName,
      "password" : this.password,
    };
    this.http.post("http://localhost:8080/user/login",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        if(resultData === "Login Sucssesfully")
        alert("Login Sucssesfully");
       else if(resultData === "Incorrect Password")
       alert("Incorrect Password");
       else
       alert("Incorrect Username");
    });
      
    }

}
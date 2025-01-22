import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { isStandalone } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-register',
  imports: [RouterLink, FormsModule],
  standalone:true,
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  username: string ="";
  firstname: string ="";
  lastname: string ="";  
  email: string ="";
  password: string="";
  role: string="";

  constructor(private router: Router,private http: HttpClient) {}
  save()
  {
  
    let bodyData = {
      "userName" : this.username,
      "firstName" : this.firstname,
      "lastName" : this. lastname,
      "email" : this.email,
      "password" : this.password,
      "role": this.role
    };
    this.http.post("http://localhost:8080/user/signIn",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        if(resultData === "User Already Exist")
        alert("User Already Exist");
       else
       alert("User Created Sucessfully");

    });
  }

}
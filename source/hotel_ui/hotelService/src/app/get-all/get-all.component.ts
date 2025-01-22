import { Component, OnInit } from '@angular/core';
import { NgFor } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common'; // Import CommonModule
import { Injectable } from '@angular/core';



interface User {
  userName: string;
  firstName: string;
  lastName: string;
  email: string;
  password: string;
  role: string;
  timestampField: Date;
} 

@Injectable({
  providedIn: 'root'
})
@Component({
  selector: 'app-get-all',
  standalone: true,
  imports: [],
  templateUrl: './get-all.component.html',
  styleUrl: './get-all.component.css'
})






export class GetAllComponent implements OnInit {

  users: User[] = [];

  constructor(private http: HttpClient, private datePipe: DatePipe) { }

  ngOnInit(): void {
    this.fetchUsers();
  }

  fetchUsers() {
    this.http.get<User[]>('http://localhost:8080/user/getall')
      .subscribe(users => {
        this.users = users;
      });
  }

  formatCreatedAt(date: Date): string {
    return this.datePipe.transform(date, 'yyyy-MM-dd HH:mm:ss') || '';
  }
}

@NgModule({
  declarations: [],
  imports: [CommonModule], // Import CommonModule here
  providers: [DatePipe],
})
export class GetAllModule{}
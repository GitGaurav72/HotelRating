import { Component, OnInit } from '@angular/core';
import { UserService } from './user.service';
import { CommonModule, NgClass } from '@angular/common';
import { DatePipe } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-user-list',
  standalone: true,
  imports: [ CommonModule],
  providers: [DatePipe],
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.css'
})
export class UserListComponent implements OnInit {
  users: any[] = [];

  constructor(private userService: UserService) { }
  // constructor(private router: Router,private http: HttpClient) {}

  ngOnInit(): void {
    
    this.userService.getUsers().subscribe((data: any[]) => {
      this.users = data;
      console.log(data);
    });
    
  }
}

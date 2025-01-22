import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'http://localhost:8080/user/getall'; // Replace with your API URL

  constructor(private http: HttpClient, ) { }

  getUsers() {
    return this.http.get<any[]>(this.apiUrl);
  }
}

import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-hotel',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './hotel.component.html',
  styleUrl: './hotel.component.css'
})
export class HotelComponent {
  imageUrl = '../../assets/pic/hotel1.jpg';
  imageUrl1 = '../../assets/pic/hotel1.jpg'; 
}

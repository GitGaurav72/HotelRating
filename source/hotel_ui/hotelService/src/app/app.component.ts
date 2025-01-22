import { CommonModule } from '@angular/common';
import { Component, input } from '@angular/core';
import { FormsModule, NgModel } from '@angular/forms';
import { RouterModule, RouterOutlet } from '@angular/router';



@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule,RouterModule,RouterOutlet,FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'front_endApp_project';
}

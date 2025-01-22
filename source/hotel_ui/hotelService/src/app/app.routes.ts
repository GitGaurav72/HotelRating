import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { HotelComponent } from './hotel/hotel.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GetAllComponent } from './get-all/get-all.component';
import { UserListComponent } from './user-list/user-list.component';
import { BrowserModule } from '@angular/platform-browser';


export const routes: Routes = [

    { path: '', component: HomeComponent, },
    { path: 'about', component: AboutComponent },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'contact', component: ContactUsComponent },
    { path: 'room', component: HotelComponent },
    { path: 'getall', component: GetAllComponent},
    { path: 'userList', component: UserListComponent},
    
];

@NgModule({
    imports: [CommonModule, RouterModule.forRoot(routes)], // Use RouterModule.forRoot for the root module
    exports: [RouterModule] // Export RouterModule to make the router directives available
})
export class AppRoutingModule { }
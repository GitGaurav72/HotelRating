import { NgModule, importProvidersFrom } from '@angular/core';
import  { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { provideHttpClient } from '@angular/common/http';
import { CommonModule, DatePipe } from '@angular/common';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { GetAllComponent } from './get-all/get-all.component';
import { UserListComponent } from './user-list/user-list.component';


@NgModule({
    declarations:[
    
    ],
    imports: [
        CommonModule,
        FormsModule,
        AppComponent,
        HttpClientModule,
        BrowserModule,
        
    ],
    providers:[provideHttpClient(),DatePipe],
    bootstrap:[]

})
export class AppModule{ }



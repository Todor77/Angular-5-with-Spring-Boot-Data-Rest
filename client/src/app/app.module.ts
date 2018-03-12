import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { CarListComponent } from './car-list/car-list.component';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CarService} from './shared/car/car.service';
import {GiphyService} from './giphy.service';
import { CarEditComponent } from './car-edit/car-edit.component';

import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';

const appRoutes = [
  {path: '', redirectTo: '/car-list', pathMatch: 'full'},
  {path: 'car-list', component: CarListComponent},
  {path: 'car-add', component: CarEditComponent},
  {path: 'car-edit/:id', component: CarEditComponent}

];

@NgModule({
  declarations: [
    AppComponent,
    CarListComponent,
    CarEditComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)

  ],
  providers: [CarService, GiphyService],
  bootstrap: [AppComponent]
})
export class AppModule { }

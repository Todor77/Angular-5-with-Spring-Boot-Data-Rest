import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {UserComponent} from './user/user.component';
import {AddUserComponent} from './add-user/add-user.component';
import {RouterModule, Routes} from '@angular/router';


const routes: Routes = [
  {path: 'users', component: UserComponent},
  {path: 'add', component: AddUserComponent}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }

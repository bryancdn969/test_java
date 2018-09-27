import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegisterPageComponent} from './register-page/register-page.component';
import {UsersListComponent} from './users-list/users-list.component';
import {SearchUsersComponent} from './search-users/search-users.component';

const routes: Routes = [
  { path: '', redirectTo: 'customer', pathMatch: 'full' },
  { path: 'customer', component: RegisterPageComponent },
  { path: 'add', component: UsersListComponent },
  { path: 'findbyname', component: SearchUsersComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }

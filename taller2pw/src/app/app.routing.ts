import { Routes, RouterModule } from '@angular/router';
import {RegisterComponent} from "./register/register.component";
import {UrlPermission} from './urlPermission/url.perimission';
import {UpdateComponent} from './M_TraceRoute/update.component';
import {NavComponent} from './nav/nav.component';
import {SearchComponent} from './M_MarkCircle/search.component';
import {RegisterPersonComponent} from './register-person/register-person.component';
import {LoginComponent} from './login/login.component';

const appRoutes: Routes = [
      { path: 'nav', component: NavComponent },
      { path: 'TraceRoute', component: UpdateComponent},
      { path: 'markCircle', component: SearchComponent},
      { path: 'Register Person', component: RegisterPersonComponent },
      { path: 'register', component: RegisterComponent },
      { path: 'login', component: LoginComponent },

  // otherwise redirect to profile
      { path: '**', redirectTo: '/login' }
];

export const routing = RouterModule.forRoot(appRoutes);

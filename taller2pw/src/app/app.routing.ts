import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {UrlPermission} from './urlPermission/url.perimission';
import {UpdateComponent} from './M_TraceRoute/update.component';
import {RouteComponent} from './M_MarkRoute/route.component';
import {NavComponent} from './nav/nav.component';
import {SearchComponent} from './M_MarkCircle/search.component';

const appRoutes: Routes = [
      { path: 'nav', component: NavComponent ,canActivate: [UrlPermission]},
      { path: 'TraceRoute', component: UpdateComponent},
      { path: 'markCircle', component: SearchComponent},
      { path: 'login', component: LoginComponent },
      { path: 'register', component: RegisterComponent },

  // otherwise redirect to profile
      { path: '**', redirectTo: '/login' }
];

export const routing = RouterModule.forRoot(appRoutes);

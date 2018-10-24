import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavComponent } from './nav/nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule, MatButtonModule, MatSidenavModule, MatIconModule, MatListModule, MatGridListModule, MatCardModule, MatMenuModule, MatTableModule, MatPaginatorModule, MatSortModule } from '@angular/material';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TableComponent } from './table/table.component';
import {RouterModule, Routes} from '@angular/router';
import { SearchComponent } from './M_search/search.component';
import { UpdateComponent } from './M_Update/update.component';
import { FormsModule }   from '@angular/forms';
import {HttpClientModule, HttpClient} from "@angular/common/http";
import {HttpModule} from '@angular/http';
import { RouteComponent } from './M_Route/route.component';
import { AgmCoreModule, GoogleMapsAPIWrapper } from '@agm/core';
import { LoginComponent } from './login/login.component';
import {RegisterComponent} from './M_Register/register.component';


const appRoutes: Routes = [
  {
    path: '',
    component: LoginComponent,
    children: [
      {path: 'Register', component: RegisterComponent},
      //{ path: 'Login', component: LoginComponent },
      {path: 'Update', component: UpdateComponent},
      {path: 'Route', component: RouteComponent}
    ]
  }
];

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    DashboardComponent,
    TableComponent,
    SearchComponent,
    UpdateComponent,
    RouteComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatMenuModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    RouterModule.forRoot(appRoutes),
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyBbsOlMryAHu2ESwHHSwrDBIUU7fiENNoM'
    }),
    FormsModule,
    HttpClientModule,
    HttpModule
  ],
  providers: [GoogleMapsAPIWrapper],
  bootstrap: [AppComponent]
})
export class AppModule { }

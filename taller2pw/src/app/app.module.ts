import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavComponent } from './nav/nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule, MatButtonModule, MatSidenavModule, MatIconModule, MatListModule, MatGridListModule, MatCardModule, MatMenuModule, MatTableModule, MatPaginatorModule, MatSortModule } from '@angular/material';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TableComponent } from './table/table.component';
import { SearchComponent } from './M_MarkCircle/search.component';
import { UpdateComponent } from './M_TraceRoute/update.component';
import { FormsModule }   from '@angular/forms';
import {HttpClientModule, HttpClient} from "@angular/common/http";
import {HttpModule} from '@angular/http';
import { RouteComponent } from './M_MarkRoute/route.component';
import { AgmCoreModule, GoogleMapsAPIWrapper } from '@agm/core';
import { LoginComponent } from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {UsersService} from './users.service';
import {UrlPermission} from './urlPermission/url.perimission';
import {routing} from "./app.routing";
import {FacebookModule} from "ngx-facebook";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

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
    //RouterModule.forRoot(app.routing.appRoutes),
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyBbsOlMryAHu2ESwHHSwrDBIUU7fiENNoM'
    }),
    FormsModule,
    HttpClientModule,
    HttpModule,
    routing,
    FacebookModule.forRoot(),
    NgbModule.forRoot()
  ],
  providers: [GoogleMapsAPIWrapper,UsersService,UrlPermission],
  bootstrap: [AppComponent]
})
export class AppModule { }

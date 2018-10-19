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
import { SearchComponent } from './search/search.component';
import { UpdateComponent } from './update/update.component';
import { FormsModule }   from '@angular/forms';
import {HttpClientModule, HttpClient} from "@angular/common/http";
import {HttpModule} from '@angular/http';
import { RouteComponent } from './route/route.component';
import { AgmCoreModule, GoogleMapsAPIWrapper } from '@agm/core';


const appRoutes: Routes = [
  { path: 'Search', component: SearchComponent },
  { path: 'Update', component: UpdateComponent },
  { path: 'Route', component: RouteComponent }

];

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    DashboardComponent,
    TableComponent,
    SearchComponent,
    UpdateComponent,
    RouteComponent
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

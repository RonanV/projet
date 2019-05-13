import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClubComponent } from './component/club/club.component';
import { ActualiteComponent } from './component/actualite/actualite.component';

@NgModule({
  declarations: [
    AppComponent,
    ClubComponent,
    ActualiteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

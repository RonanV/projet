import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClubComponent } from './component/club/club.component';
import { ContactComponent } from './component/contact/contact.component'
import { ActualiteComponent } from './component/actualite/actualite.component';
import { ArticleServiceService } from '../app/service/article-service.service';
import { CalendrierComponent } from './component/calendrier/calendrier.component';

@NgModule({
  declarations: [
    AppComponent,
    ClubComponent,
    ActualiteComponent,
    ContactComponent,
    CalendrierComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ArticleServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }

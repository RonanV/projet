import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClubComponent } from './club/club.component';
import { ActualiteComponent } from './actualite/actualite.component';

const routes: Routes = [
  //{ path: 'club', component: ClubComponent }
  { path: '', component: ClubComponent },
  { path: 'actu', component: ActualiteComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

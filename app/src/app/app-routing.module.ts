import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClubComponent } from './component/club/club.component';
import { ActualiteComponent } from './component/actualite/actualite.component';

const routes: Routes = [
  //{ path: 'club', component: ClubComponent }
  { path: '', component: ActualiteComponent },
  { path: 'association', component: ClubComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

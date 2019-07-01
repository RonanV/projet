import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClubComponent } from './component/club/club.component';
import { ActualiteComponent } from './component/actualite/actualite.component';
import { ContactComponent } from './component/contact/contact.component'
import { CalendrierComponent } from './component/calendrier/calendrier.component';
import { DisciplineComponent } from './component/discipline/discipline.component';
import { ConnectComponent } from './component/connect/connect.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { RgpdComponent } from './component/rgpd/rgpd.component';

const routes: Routes = [
  //{ path: 'club', component: ClubComponent }
  { path: '', component: ActualiteComponent },
  { path: 'club', component: ClubComponent },
  { path: 'contact', component: ContactComponent},
  { path: 'calendrier', component: CalendrierComponent},
  { path: 'discipline', component: DisciplineComponent},
  { path: 'connect', component: ConnectComponent},
  { path: 'inscription', component: InscriptionComponent},
  { path: 'rgpd', component: RgpdComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

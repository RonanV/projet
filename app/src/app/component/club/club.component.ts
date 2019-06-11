import { Component, OnInit } from '@angular/core';
import { Personne } from 'src/app/models/personne';
import { PersonneService } from 'src/app/service/personne.service';


@Component({
  selector: 'app-club',
  templateUrl: './club.component.html',
  styleUrls: ['./club.component.css']
})
export class ClubComponent implements OnInit {
  
  public asso:boolean = true;
  public bureau:boolean = false;
  public entraineur:boolean = false;
  public juge:boolean = false;
  public groupe:boolean = false;
  public tenu:boolean = false;

  tache_bureau:Array = [];
  tache_comite:Array = [];
  tache_entraineur_gym:Array = [];
  tache_entraineur_trampo:Array = [];
  tache_entraineur_petit:Array = [];
  tache_entraineur_zumba:Array = [];
  tache_juge_gym:Array = [];
  tache_juge_trampo:Array = [];
  membre:Array = [];
  membreb:Array = [];

  personnes:Personne[];


  constructor(private personneService: PersonneService) { 
    
  }

  ngOnInit() {
    this.personneService.findAll().subscribe(data =>{
      this.personnes = data;
      for (let i=0; i < this.personnes.length ; i++) {
        for (let j=0; j < this.personnes[i].tache.length; j++){
          if(this.personnes[i].tache[j].tache.idtache === 1){
            this.membre.detail = this.personnes[i].tache[j].detail;
            this.membre.nom = this.personnes[i].tache[j].personne.nom_Personne;
            this.membre.prenom = this.personnes[i].tache[j].personne.prenom_Personne;
            this.membre.photo = this.personnes[i].tache[j].personne.idphoto;
            this.tache_bureau.push(this.membre);
            this.membre = [];
          }
          if(this.personnes[i].tache[j].tache.idtache === 2){
            this.membre.detail = this.personnes[i].tache[j].detail;
            this.membre.nom = this.personnes[i].tache[j].personne.nom_Personne;
            this.membre.prenom = this.personnes[i].tache[j].personne.prenom_Personne;
            this.membre.photo = this.personnes[i].tache[j].personne.idphoto;
            this.tache_comite.push(this.membre);
            this.membre = [];
          }
          if(this.personnes[i].tache[j].tache.idtache === 3){
            this.membre.detail = this.personnes[i].tache[j].detail;
            this.membre.nom = this.personnes[i].tache[j].personne.nom_Personne;
            this.membre.prenom = this.personnes[i].tache[j].personne.prenom_Personne;
            this.membre.photo = this.personnes[i].tache[j].personne.idphoto;
            this.tache_entraineur_gym.push(this.membre);
            this.membre = [];
          }
          if(this.personnes[i].tache[j].tache.idtache === 4){
            this.membre.detail = this.personnes[i].tache[j].detail;
            this.membre.nom = this.personnes[i].tache[j].personne.nom_Personne;
            this.membre.prenom = this.personnes[i].tache[j].personne.prenom_Personne;
            this.membre.photo = this.personnes[i].tache[j].personne.idphoto;
            this.tache_entraineur_trampo.push(this.membre);
            this.membre = [];
          }
          if(this.personnes[i].tache[j].tache.idtache === 5){
            this.membre.detail = this.personnes[i].tache[j].detail;
            this.membre.nom = this.personnes[i].tache[j].personne.nom_Personne;
            this.membre.prenom = this.personnes[i].tache[j].personne.prenom_Personne;
            this.membre.photo = this.personnes[i].tache[j].personne.idphoto;
            this.tache_entraineur_petit.push(this.membre);
            this.membre = [];
          }
          if(this.personnes[i].tache[j].tache.idtache === 6){
            this.membre.detail = this.personnes[i].tache[j].detail;
            this.membre.nom = this.personnes[i].tache[j].personne.nom_Personne;
            this.membre.prenom = this.personnes[i].tache[j].personne.prenom_Personne;
            this.membre.photo = this.personnes[i].tache[j].personne.idphoto;
            this.tache_entraineur_zumba.push(this.membre);
            this.membre = [];
          }
          if(this.personnes[i].tache[j].tache.idtache === 7){
            this.membre.detail = this.personnes[i].tache[j].detail;
            this.membre.nom = this.personnes[i].tache[j].personne.nom_Personne;
            this.membre.prenom = this.personnes[i].tache[j].personne.prenom_Personne;
            this.membre.photo = this.personnes[i].tache[j].personne.idphoto;
            this.tache_juge_gym.push(this.membre);
            this.membre = [];
          }
          if(this.personnes[i].tache[j].tache.idtache === 8){
            this.membre.detail = this.personnes[i].tache[j].detail;
            this.membre.nom = this.personnes[i].tache[j].personne.nom_Personne;
            this.membre.prenom = this.personnes[i].tache[j].personne.prenom_Personne;
            this.membre.photo = this.personnes[i].tache[j].personne.idphoto;
            this.tache_juge_trampo.push(this.membre);
            this.membre = [];
          }
        
        }
      }
    });
  }

  display(name){
    if(name=="asso"){
      this.asso = true;
      this.bureau = false;
      this.entraineur = false;
      this.juge = false;
      this.groupe = false;
      this.tenu = false;
    }

    if(name=="bureau"){
      this.asso = false;
      this.bureau = true;
      this.entraineur = false;
      this.juge = false;
      this.groupe = false;
      this.tenu = false;
    }

    if(name=="entraineur"){
      this.asso = false;
      this.bureau = false;
      this.entraineur = true;
      this.juge = false;
      this.groupe = false;
      this.tenu = false;
    }

    if(name=="juge"){
      this.asso = false;
      this.bureau = false;
      this.entraineur = false;
      this.juge = true;
      this.groupe = false;
      this.tenu = false;
    }

    if(name=="groupe"){
      this.asso = false;
      this.bureau = false;
      this.entraineur = false;
      this.juge = false;
      this.groupe = true;
      this.tenu = false;
    }

    if(name=="tenue"){
      this.asso = false;
      this.bureau = false;
      this.entraineur = false;
      this.juge = false;
      this.groupe = false;
      this.tenu = true;
    }
  }

}

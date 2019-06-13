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

  tache_bureau = [];
  tache_comite = [];
  tache_entraineur_gym = [];
  tache_entraineur_trampo = [];
  tache_entraineur_petit = [];
  tache_entraineur_zumba = [];
  tache_juge_gym = [];
  tache_juge_trampo = [];

  personnes:Personne[];


  constructor(private personneService: PersonneService) { 
    
  }

  ngOnInit() {
    this.personneService.findAll().subscribe(data =>{
      this.personnes = data;
      for (let i=0; i < this.personnes.length ; i++) {
        for (let j=0; j < this.personnes[i].tache.length; j++){
          if(this.personnes[i].tache[j]['tache']['idtache'] === 1){
            this.tache_bureau.push({ 
              detail : this.personnes[i].tache[j]['detail'],
              nom : this.personnes[i].tache[j]['personne']['nomPersonne'],
              prenom : this.personnes[i].tache[j]['personne']['prenomPersonne'],
              photo: this.personnes[i].tache[j]['personne']['idphoto']
             });
          }
          if(this.personnes[i].tache[j]['tache']['idtache'] === 2){
            this.tache_comite.push({ 
              detail : this.personnes[i].tache[j]['detail'],
              nom : this.personnes[i].tache[j]['personne']['nomPersonne'],
              prenom : this.personnes[i].tache[j]['personne']['prenomPersonne'],
              photo: this.personnes[i].tache[j]['personne']['idphoto']
             });
          }
          if(this.personnes[i].tache[j]['tache']['idtache'] === 3){
            this.tache_entraineur_gym.push({ 
              detail : this.personnes[i].tache[j]['detail'],
              nom : this.personnes[i].tache[j]['personne']['nomPersonne'],
              prenom : this.personnes[i].tache[j]['personne']['prenomPersonne'],
              photo: this.personnes[i].tache[j]['personne']['idphoto']
             });
          }
          if(this.personnes[i].tache[j]['tache']['idtache'] === 4){
            this.tache_entraineur_trampo.push({ 
              detail : this.personnes[i].tache[j]['detail'],
              nom : this.personnes[i].tache[j]['personne']['nomPersonne'],
              prenom : this.personnes[i].tache[j]['personne']['prenomPersonne'],
              photo: this.personnes[i].tache[j]['personne']['idphoto']
             });
          }
          if(this.personnes[i].tache[j]['tache']['idtache'] === 5){
            this.tache_entraineur_petit.push({ 
              detail : this.personnes[i].tache[j]['detail'],
              nom : this.personnes[i].tache[j]['personne']['nomPersonne'],
              prenom : this.personnes[i].tache[j]['personne']['prenomPersonne'],
              photo: this.personnes[i].tache[j]['personne']['idphoto']
             });
          }
          if(this.personnes[i].tache[j]['tache']['idtache'] === 6){
            this.tache_entraineur_zumba.push({ 
              detail : this.personnes[i].tache[j]['detail'],
              nom : this.personnes[i].tache[j]['personne']['nomPersonne'],
              prenom : this.personnes[i].tache[j]['personne']['prenomPersonne'],
              photo: this.personnes[i].tache[j]['personne']['idphoto']
             });
          }
          if(this.personnes[i].tache[j]['tache']['idtache'] === 7){
            this.tache_juge_gym.push({ 
              detail : this.personnes[i].tache[j]['detail'],
              nom : this.personnes[i].tache[j]['personne']['nomPersonne'],
              prenom : this.personnes[i].tache[j]['personne']['prenomPersonne'],
              photo: this.personnes[i].tache[j]['personne']['idphoto']
             });
          }
          if(this.personnes[i].tache[j]['tache']['idtache'] === 8){
            this.tache_juge_trampo.push({ 
              detail : this.personnes[i].tache[j]['detail'],
              nom : this.personnes[i].tache[j]['personne']['nomPersonne'],
              prenom : this.personnes[i].tache[j]['personne']['prenomPersonne'],
              photo: this.personnes[i].tache[j]['personne']['idphoto']
             });
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

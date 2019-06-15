import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { Router } from '@angular/router';
import { SearchService } from '../../service/search.service'
import { SearchIdService } from '../../service/search-id.service'
import { GroupeService } from '../../service/groupe.service'
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-connect',
  templateUrl: './connect.component.html',
  styleUrls: ['./connect.component.css']
})
export class ConnectComponent implements OnInit{
  perso:boolean = false;
  modif_pers:boolean = false;
  gestion_groupe:boolean = false;
  result:String = "";
  chemin_Photo:String= "";
  resultError:boolean = false;
  resultSearch1:boolean = false;
  resultSearchTrue:boolean = false;
  resultadhe:boolean = false;
  creat_group:boolean = false;
  modgroupe:boolean = false;
  bureau:String = "";
  comite:String = "";
  E_G:String = "";
  E_T:String = "";
  E_P:String = "";
  E_Z:String = "";
  J_G:String = "";
  J_T:String = "";


  tache = [];
  info = [];
  inforesult = [];
  info_groupe = [];
  info_groupe_modif = [];
  info_groupe_pers = [];

  constructor(private app:AppComponent, 
    private router:Router, 
    private SearchService: SearchService, 
    private SearchIdService: SearchIdService,
    private groupeService: GroupeService) { }

  ngOnInit() {
    localStorage.getItem('idpersonne')

    this.SearchIdService.findAll(localStorage.getItem('idpersonne')).subscribe(data =>{
      this.info = data;
   });
   this.display_groupe();
  }

  display(name){
    if(name=="perso"){
      if(this.perso){
      this.perso = false;
      }else{
      this.perso = true;
      }
    }
    if(name=="modif_pers"){
      if(this.modif_pers){
      this.modif_pers = false;
      this.resultSearch1 = false;
      }else{
      this.modif_pers = true;
      }
    }
    if(name=="gestion_groupe"){
      if(this.gestion_groupe){
      this.gestion_groupe = false;
      }else{
      this.gestion_groupe = true;
      }
    }
  }

  register(f: NgForm) {
    let value;
    console.log(f.value)
    if(f.value.search_nom != ""){
     value = f.value.search_nom;
    }
    else if(f.value.search_prenom != ""){
      value = f.value.search_prenom;
     }
     else if(f.value.search_naissance != ""){
      value = f.value.search_naissance;
     }
     else if(f.value.search_mail != ""){
      value = f.value.search_mail;
     }
     else if(f.value.search_num != ""){
      value = f.value.search_num;
     }
    this.SearchService.findAll(value).subscribe(data =>{
      this.info = data;
      console.log('info', data)
      this.resultSearch();
    });
  }

  resultSearch(){
    console.log('info_result', this.info)
    this.resultSearch1 = true;
    if(this.info.length > 0){
      this.resultSearchTrue = true;
      this.resultadhe = false;
      this.resultError = false;
    }else{
      this.resultError = true;
      this.resultadhe = false;
    }
  }

  modif(id){
    console.log('id', id)
    this.SearchIdService.findAll(id).subscribe(data =>{
      this.inforesult = data;
      this.resultadhe = true;
      console.log('inforesult', this.inforesult);
      
        let long = this.inforesult['idsaison'].length;
        let saison = this.inforesult['idsaison'][--long]['libellesaison']

        for(let j = 0; j < this.inforesult['groupe'].length; j++){
          console.log('test')
          for(let i = 0; i < this.info_groupe.length; i++){
            if(this.inforesult['groupe'][j].idgroupe === this.info_groupe[i].idgroupe)
            this.info_groupe_pers.push({
              nom : this.inforesult['groupe'][j].libellegrp,
              id_group : this.inforesult['groupe'][j].idgroupe
            }) 
          }
        }
      console.log('les groupes', this.info_groupe_pers)

        for(let j = 0; j < this.inforesult['tache'].length; j++){
          if(this.inforesult['tache'][j].tache.idtache === 1){
            this.bureau = this.inforesult['tache'][j].detail;
            console.log('bureua', this.bureau)
          }
          if(this.inforesult['tache'][j].tache.idtache === 2){
            this.comite = this.inforesult['tache'][j].detail;
            console.log('comite', this.comite)
          }
          if(this.inforesult['tache'][j].tache.idtache === 3){
            this.E_G = this.inforesult['tache'][j].detail;
            console.log('eg', this.E_G)
          }
          if(this.inforesult['tache'][j].tache.idtache === 4){
            this.E_T = this.inforesult['tache'][j].detail;
            console.log('et', this.E_T)
          }
          if(this.inforesult['tache'][j].tache.idtache === 5){
            this.E_P = this.inforesult['tache'][j].detail;
            console.log('ep', this.E_P)
          }
          if(this.inforesult['tache'][j].tache.idtache === 6){
            this.E_Z = this.inforesult['tache'][j].detail;
            console.log('ez', this.E_Z)
          }
          if(this.inforesult['tache'][j].tache.idtache === 7){
            this.J_G = this.inforesult['tache'][j].detail;
            console.log('jg', this.J_G)
          }
          if(this.inforesult['tache'][j].tache.idtache === 8){
            this.J_T = this.inforesult['tache'][j].detail;
            console.log('jt', this.J_T)
          }
        }
   });
  }

  creat_groupe(){
    if(this.creat_group){
      this.creat_group = false;
    }else{
      this.creat_group = true;
    }
  }

  display_groupe(){
    this.groupeService.findAll().subscribe(data =>{
      this.info_groupe = data;
      console.log('groupe',data)
   });
  }

  modifGroupe(id){
    console.log(id)
    if(!this.modgroupe){
      this.modgroupe = true;
      for(let i = 0; this.info_groupe.length; i++){
        if(this.info_groupe[i].idgroupe == id){
          this.info_groupe_modif.push({ 
            limite : this.info_groupe[i]['limitemax'],
            nom : this.info_groupe[i]['libellegrp'],
            tarif : this.info_groupe[i]['tarif_Groupe'],
            min: this.info_groupe[i]['anne_Min'],
            max: this.info_groupe[i]['anne_Max'],
           });
        }
        break;
      }
      console.log('info_groupe', this.info_groupe)
    }
  }

  register_modif_groupe(f: NgForm) {
console.log(f.value)
  }


}

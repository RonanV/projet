import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { Router } from '@angular/router';
import { SearchService } from '../../service/search.service'
import { SearchIdService } from '../../service/search-Id.service'
import { NgForm } from '@angular/forms';
import { BrowserStack } from 'protractor/built/driverProviders';
import { Search } from 'src/app/models/search';

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

  constructor(private app:AppComponent, private router:Router, private SearchService: SearchService, private SearchIdService: SearchIdService) { }

  ngOnInit() {
    localStorage.getItem('idpersonne')

    this.SearchIdService.findAll(localStorage.getItem('idpersonne')).subscribe(data =>{
      this.info = data;
   });

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
      this.resultSearch();
    });
  }

  resultSearch(){
    console.log('info_result', this.info)
    this.resultSearch1 = true;
    if(this.info.length > 0){
      this.resultSearchTrue = true;
      this.resultadhe = false;
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
      console.log(this.inforesult['tache'].length);
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

}

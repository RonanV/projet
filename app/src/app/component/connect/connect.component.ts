import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { Router } from '@angular/router';
import { SearchService } from '../../service/search.service'
import { SearchIdService } from '../../service/search-id.service'
import { GroupeService } from '../../service/groupe.service'
import { ArticleServiceService } from '../../service/article-service.service' 
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
  add_article:boolean = false;
  gestion_article:boolean = false;
  result:String = "";
  chemin_Photo:String= "";
  resultError:boolean = false;
  resultSearch1:boolean = false;
  resultSearchTrue:boolean = false;
  inscription:boolean = false;
  resultadhe:boolean = false;
  creat_group:boolean = false;
  modgroupe:boolean = false;
  modif_article:boolean = false;
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
  info_groupe_id = [];
  info_article_id = [];
  info_article_modif = [];
  articles: any;

  constructor(private app:AppComponent, 
    private router:Router, 
    private SearchService: SearchService, 
    private SearchIdService: SearchIdService,
    private groupeService: GroupeService,
    private ArticleService:  ArticleServiceService) { }

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
      this.modgroupe = false;
      }else{
      this.gestion_groupe = true;
      }
    }
    if(name=="add_article"){
      if(this.add_article){
      this.add_article = false;
      }else{
      this.add_article = true;
      }
    }
    if(name=="gestion_article"){
      if(this.gestion_article){
      this.gestion_article = false;
      }else{
      this.gestion_article = true;
      this.ArticleService.findAll().subscribe(data =>{
        this.articles = data['content'];
        console.log('articles', this.articles)
      });
      }
    }
    if(name=="inscription"){
      if(this.inscription){
      this.inscription = false;
      }else{
      this.inscription = true;
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

    for(let j = 0; j < this.info.length; j++){
      console.log('test')
      for(let k = 0; k < this.info[j]['groupe'].length; k++){
        /* if(this.inforesult['groupe'][j].idgroupe === this.info_groupe[j].idgroupe) */
        this.info_groupe_pers.push({
          nom : this.info[j]['groupe'][k].libellegrp,
          id_group : this.info[j]['groupe'][k].idgroupe
        }) ;
      }
      this.info_groupe_pers.push({
        id : this.info[j].idpersonne
      }) ;
    }
  console.log('les groupes', this.info_groupe_pers)

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
    }
      this.groupeService.findAllById(id).subscribe(data =>{
        this.info_groupe_modif = data;
        console.log('groupebyId',data)
     }); this.info_groupe_id = [];
          this.info_groupe_id.push({ 
            limite : this.info_groupe_modif['limitemax'],
            nom : this.info_groupe_modif['libellegrp'],
            tarif : this.info_groupe_modif['tarif_Groupe'],
            min: this.info_groupe_modif['anne_Min'],
            max: this.info_groupe_modif['anne_Max'],
           });
      console.log('info_groupe_id', this.info_groupe_id)
    }
  

  register_modif_groupe(f: NgForm) {
    console.log('modif_group',f.value);
  }

  register_creat_groupe(f: NgForm) {
    console.log('creat_groupe', f.value);
  }

  register_create_article(f: NgForm){
    console.log('create_article',f.value);
  }

  register_update_article(f: NgForm){
    console.log('update_article',f.value);
  }

  register_update_user(f: NgForm) {
    console.log('update_user', f.value);
  }

  register_update_user_search(f: NgForm) {
    console.log('update_user_search', f.value)
  }

  modifArticle(id){
    this.modif_article = true;
    this.ArticleService.findAllById(id).subscribe(data =>{
      this.info_article_id = [];
        this.info_article_id.push({ 
          date : data['date_article'],
          text : data['texte_article'],
          titre_article : data['titre_article'],
          id : data['idarticle']
         });
         console.log('data', data)
         console.log('info_article_id', this.info_article_id)
   }); 
  
  }

  inscrit(){
    console.log('test')
  }


}

import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { SearchIdService } from 'src/app/service/search-id.service';
import { PersonneService } from 'src/app/service/personne.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'etoiles-project';
  user:boolean = false;
  mdp:boolean = false;
  verif:boolean = false;
  verification:boolean = false;
  login:String = "Se connecter";
  id:String = "";
  psw:String = "";

  constructor( private router:Router, private personneService: PersonneService, private searchIdService: SearchIdService){
    
  }

  ngOnInit() {
   this.display();
  }

  display(){
    
    if(localStorage.getItem('idpersonne') != ""){
      this.searchIdService.findAll(localStorage.getItem('idpersonne')).subscribe(data =>{
        console.log('data', data);
        this.login = data['nomPersonne'] + " " + data['prenomPersonne'];
        localStorage.setItem('idpersonne', data['idpersonne']);
      });
    }else{
      document.getElementById('id01').style.display='block';
    }
    return "none";
  }

  register(f: NgForm) {
    if(!f.valid){
      if(f.value.uname==""){
        this.user = true;
      }else{
        this.user = false;
      }
      if(f.value.psw==""){
        this.mdp = true;
      }else{
        this.mdp= false;
      }
    }else{
      this.user = false;
      this.mdp = false;
      this.id=f.value.uname;
      this.psw=f.value.psw;
      this.personneService.findAllPass(this.id, this.psw).subscribe(data =>{
        this.verif = true;
        (document.getElementById('id01').style.display='none');
        this.router.navigateByUrl('/connect');
        f.reset(1);
        this.login = data['nomPersonne'] + " " + data['prenomPersonne'];
        localStorage.setItem('idpersonne', data['idpersonne']);
      }, erreur => {
        this.verification = true;
      });
    }
  }
  

}

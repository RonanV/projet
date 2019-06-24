import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { SearchIdService } from 'src/app/service/search-id.service';
import { PersonneService } from 'src/app/service/personne.service';
import { AuthenticationService } from './service/authentication.service';
import { HttpResponse } from '@angular/common/http';

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
  log:boolean = false;
  id:String = "";
  psw:String = "";
  login: string = "Se connecter";
  

  constructor( private router:Router, private personneService: PersonneService, private authentication : AuthenticationService, private searchIdService : SearchIdService){
    
  }

  ngOnInit() {
    console.log(localStorage.getItem('idpersonne'))
    if(localStorage.getItem('idpersonne') != null){
      this.searchIdService.findAll(localStorage.getItem('idpersonne')).subscribe(data =>{
        console.log('data', data);
        this.login = data['nomPersonne'] + " " + data['prenomPersonne'];
        localStorage.setItem('idpersonne', data['idpersonne']);
      });
    }
  }

  display(){
    console.log(localStorage.getItem('idpersonne'))
  
    if(localStorage.getItem('idpersonne') != null){
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

  disconnect(){
    localStorage.removeItem('idpersonne')
    this.router.navigate(['/'])
    this.login = "Se connecter";
    console.log('deconnecter')
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
      console.log()
      this.authentication.login(this.id, this.psw).subscribe(result  =>{
          console.log('token',result);
          this.verification = false;
        }, erreur => {
        this.verification = true;
      });


      /* this.personneService.findAllPass(this.id, this.psw).subscribe(data =>{
        this.verif = true;
        (document.getElementById('id01').style.display='none');
        this.router.navigateByUrl('/connect');
        f.reset(1);
        this.login = data['nomPersonne'] + " " + data['prenomPersonne'];
        localStorage.setItem('idpersonne', data['idpersonne']);
      }, erreur => {
        this.verification = true;
      }); */
    }
  }


}

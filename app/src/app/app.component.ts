import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Personne } from 'src/app/models/personne';
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

  constructor( private router:Router, private personneService: PersonneService){
    
  }

  ngOnInit() {

  }

  display(){
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
        console.log(data);
        this.verif = true;
        (document.getElementById('id01').style.display='none');
        this.router.navigateByUrl('/connect');
        f.reset(1);
        this.login = "Guillaume DELMARLE";
      }, erreur => {
        console.log(erreur.error.message);
        this.verification = true;
      });
    }
  }
  

}

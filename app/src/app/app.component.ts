import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'etoiles-project';
  user:boolean = false;
  mdp:boolean = false;
  verif:boolean = true;
  verification:boolean = false;
  login:String = "Se connecter";

  constructor( private router:Router){
    
  }

  ngOnInit() {

  }

  display(){
    return "none";
  }

  register(f: NgForm) {
    console.log(f.value);  // { first: '', last: '' }
    console.log(f.valid);  // false
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
      //TEST BASE
      if(this.verif){
        (document.getElementById('id01').style.display='none');
        this.router.navigateByUrl('/connect');
        f.reset(1);
        this.login = "Guillaume DELMARLE";
      }else{
        this.verification = true;
      }
    }
  }
  

}

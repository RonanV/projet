import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { Router } from '@angular/router';
import { Personne } from 'src/app/models/personne';

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

  constructor(private app:AppComponent, private router:Router) { }

  ngOnInit() {
  }

  display(name){
    console.log(name);
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
}

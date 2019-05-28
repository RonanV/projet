import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-connect',
  templateUrl: './connect.component.html',
  styleUrls: ['./connect.component.css']
})
export class ConnectComponent implements OnInit{
  perso:boolean = false;

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

  }
}

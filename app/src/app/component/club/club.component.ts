import { Component, OnInit } from '@angular/core';

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


  constructor() { 
    
  }

  ngOnInit() {
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
  }

}

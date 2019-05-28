import { Component, OnInit } from '@angular/core';
import { Personne } from 'src/app/models/personne';
import { PersonneService } from 'src/app/service/personne.service';


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

  personne:Personne[];


  constructor(private personneService: PersonneService) { 
    
  }

  ngOnInit() {
    this.personneService.findAll().subscribe(data =>{
      this.personne = data;
      console.log("data",data);
    });
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

    if(name=="entraineur"){
      this.asso = false;
      this.bureau = false;
      this.entraineur = true;
      this.juge = false;
      this.groupe = false;
      this.tenu = false;
    }

    if(name=="juge"){
      this.asso = false;
      this.bureau = false;
      this.entraineur = false;
      this.juge = true;
      this.groupe = false;
      this.tenu = false;
    }

    if(name=="groupe"){
      this.asso = false;
      this.bureau = false;
      this.entraineur = false;
      this.juge = false;
      this.groupe = true;
      this.tenu = false;
    }

    if(name=="tenue"){
      this.asso = false;
      this.bureau = false;
      this.entraineur = false;
      this.juge = false;
      this.groupe = false;
      this.tenu = true;
    }
  }

}

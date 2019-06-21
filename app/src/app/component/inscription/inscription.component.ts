import { Component, OnInit } from '@angular/core';
import { GroupeService } from '../../service/groupe.service'
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  constructor(private groupeService: GroupeService) { }

  info_groupe = [];

  ngOnInit() {
    this.groupeService.findAll().subscribe(data =>{
      this.info_groupe = data;
      console.log('groupe',data)
   });
  }

  register_add_inscrit(f: NgForm) {
    console.log('add', f.value)
  }

}

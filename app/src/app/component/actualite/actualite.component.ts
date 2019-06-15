import { Component, OnInit } from '@angular/core';
import { Article } from '../../models/article';
import { ArticleServiceService } from '../../service/article-service.service' 
import { InscriptionComponent } from '../inscription/inscription.component';



@Component({
  selector: 'app-actualite',
  templateUrl: './actualite.component.html',
  styleUrls: ['./actualite.component.css']
})
export class ActualiteComponent implements OnInit {
  
  articles : Article[];

  constructor(private ArticleService: ArticleServiceService) { }

  ngOnInit() {
   this.ArticleService.findAll().subscribe(data =>{
     this.articles = data['content'];
     console.log('article',data);
     console.log('pers aticle', this.articles[0]['idpersonne'].numlicence)
   });
  }

  inscription(){
    alert('test')
  }
  
  

}

import { Component, OnInit } from '@angular/core';
import { Article } from '../../service/article';
import { ArticleServiceService } from '../../service/article-service.service' 



@Component({
  selector: 'app-actualite',
  templateUrl: './actualite.component.html',
  styleUrls: ['./actualite.component.css']
})
export class ActualiteComponent implements OnInit {

  article: Article[];

  constructor(private ArticleService: ArticleServiceService) { }

  ngOnInit() {
   this.ArticleService.findAll().subscribe(data =>{
     this.article = data;
   });
   console.log(this.article);
  }



  

}

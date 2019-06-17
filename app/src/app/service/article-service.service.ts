import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Article } from '../models/article';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArticleServiceService {

  private urlArticle: string;

  constructor(private http: HttpClient) { 
    this.urlArticle = 'https://localhost:3401/articles'
  }

  public findAll(): Observable<Article[]> {
    return this.http.get<Article[]>(this.urlArticle);
  }

  public save(article: Article){
    return this.http.post<Article>(this.urlArticle, article);
  }
}

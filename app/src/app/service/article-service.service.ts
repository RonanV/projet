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
    this.urlArticle = 'http://localhost:8080/articles/all'
  }

  public findAll(): Observable<Article[]> {
    return this.http.get<Article[]>(this.urlArticle);
  }

  public findAllById(id): Observable<Article[]> {
    return this.http.get<Article[]>('http://localhost:8080/articles/id?id=' + id);
  }

  public save(article: Article){
    return this.http.post<Article>(this.urlArticle, article);
  }
}

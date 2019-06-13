import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Article } from '../models/article';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchIdService {

  private urlArticle: string;

  constructor(private http: HttpClient) { 
    this.urlArticle = 'http://localhost:8080/personnes/id?id='
  }

  public findAll(id): Observable<Article[]> {
    return this.http.get<Article[]>(this.urlArticle + id);
  }

  public save(article: Article){
    return this.http.post<Article>(this.urlArticle, article);
  }
}

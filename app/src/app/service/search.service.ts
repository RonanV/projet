import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Article } from '../models/article';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private urlArticle: string;

  constructor(private http: HttpClient) { 
    this.urlArticle = 'http://localhost:8080/personnes/search?search='
  }

  public findAll(search): Observable<Article[]> {
    return this.http.get<Article[]>(this.urlArticle + search);
  }

  public save(article: Article){
    return this.http.post<Article>(this.urlArticle, article);
  }
}


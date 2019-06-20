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
    this.urlArticle = 'http://localhost:3401/articles'
  }

  public findAll(): Observable<Article[]> {
    let headers = new HttpHeaders();
    var username = "1234";
    var password = "1234";
    headers = headers.set("Authorization", "Basic " + btoa(username + ':' +password));
     /* headers.set('ContentType', 'application/json');
      headers.set('Accept', 'application/json');
      headers.set('Access-Control-Allow-Origin', '*');
      headers.set('Access-Control-Allow-Methods','POST, GET, OPTIONS, DELETE, PUT');*/
    
      return this.http.get<Article[]>(this.urlArticle,{headers:headers})
  }

  public save(article: Article){
    return this.http.post<Article>(this.urlArticle, article);
  }
}

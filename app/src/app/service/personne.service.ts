import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Personne } from '../models/personne';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonneService {

  private urlPersonne: string;

  constructor(private http: HttpClient) { 
    this.urlPersonne = 'http://localhost:8080/personnes/all'
    this.urlPersonne2 = 'http://localhost:8080/personnes/verif?id=1&numero='
  }

  public findAll(): Observable<Personne[]> {
    return this.http.get<Personne[]>(this.urlPersonne);
  }

  public save(personne: Personne){
    return this.http.post<Personne>(this.urlPersonne, personne);
  }

  public findAllPass(user, pass): Observable<Personne[]> {
    return this.http.get<Personne[]>(this.urlPersonne2 + user + "&pass=" + pass);
  }

  public savePass(personne: Personne){
    return this.http.post<Personne>(this.urlPersonne2 + user + "&mdp=" + pass, personne);
  }
}

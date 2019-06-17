import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Personne } from '../models/personne';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonneService {

  private urlPersonne: string;
  private urlPersonne2: string;

  constructor(private http: HttpClient) { 
    this.urlPersonne = 'https://localhost:8080/personnes/all'
    this.urlPersonne2 = 'https://localhost:8080/personnes/verif?numero='
  }

  public findAll(): Observable<Personne[]> {
    return this.http.get<Personne[]>(this.urlPersonne);
  }

  public save(personne: Personne){
    return this.http.post<Personne>(this.urlPersonne, personne);
  }

  public findAllPass(user, pass): Observable<Personne[]> {
    this.urlPersonne2 = 'https://localhost:3401/personnes/verif?numero=' + user + "&pass=" + pass;
    return this.http.get<Personne[]>(this.urlPersonne2);
  }

  public savePass(personne: Personne){
    return this.http.post<Personne>(this.urlPersonne2, personne);
  }
}

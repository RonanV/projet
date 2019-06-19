import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Groupe } from '../models/groupe';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GroupeService {

 
  private urlGroupe: string;

  constructor(private http: HttpClient) { 
    this.urlGroupe = 'http://localhost:8080/groupes/all'
  }

  public findAll(): Observable<Groupe[]> {
    return this.http.get<Groupe[]>(this.urlGroupe);
  }

  public findAllById(id): Observable<Groupe[]> {
    return this.http.get<Groupe[]>('http://localhost:8080/groupes/id?id=' + id);
  }


  public save(groupe: Groupe){
    return this.http.post<Groupe>(this.urlGroupe, groupe);
  }
}

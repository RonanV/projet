import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Personne } from '../models/personne';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private currentUserSubject: BehaviorSubject<Personne>;
  public currentUser: Observable<Personne>;

  urlPersonne2:String = "";
  p = [];

  constructor(private http: HttpClient) {
      this.currentUserSubject = new BehaviorSubject<Personne>(JSON.parse(localStorage.getItem('id')));
      this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): Personne {
      return this.currentUserSubject.value;
  }

  login(username: String, password: String) {
     this.p.push({ numero: username, pass:password });
      return this.http.post<any>(`http://localhost:8080/personnes/verif`, this.p)
          .pipe(map(user => {
              // login successful if there's a jwt token in the response
              if (user && user.token) {
                  // store user details and jwt token in local storage to keep user logged in between page refreshes
                  localStorage.setItem('currentUser', JSON.stringify(user));
                  this.currentUserSubject.next(user);
              }

              return user;
          }));
  }

  logout() {
      // remove user from local storage to log user out
      localStorage.removeItem('currentUser');
      this.currentUserSubject.next(null);
  }
}

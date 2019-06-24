import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
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
      this.p = [];
     this.p.push({ numlicence: username, password:password });
     console.log('p',this.p[0])
     return this.http.post(`http://localhost:3401/login`, JSON.stringify(this.p[0]))
            .pipe(map((response : HttpResponse<any>) => {
                console.log('response', response)
                return response;
            }));
     /*  return this.http.post<any>(`http://localhost:3401/login`, this.p[0])
          .pipe(map(user => {
              console.log('test2')
              // login successful if there's a jwt token in the response
              if (user && user.token) {
                  // store user details and jwt token in local storage to keep user logged in between page refreshes
                  localStorage.setItem('currentUser', JSON.stringify(user));
                  this.currentUserSubject.next(user);
              }

              return user;
          })); */
  }

  logout() {
      // remove user from local storage to log user out
      localStorage.removeItem('currentUser');
      this.currentUserSubject.next(null);
  }
}

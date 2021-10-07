import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subscriber } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  authenticate(username: string, password: string){
    return this.http.post("http://localhost:8050/user/authenticate", {username: username, password: password})
    .subscribe(
      (userData: any)=> {
        console.log(userData);
        sessionStorage.setItem('username', username);
        let token= "Bearer "+userData.jwt;
        sessionStorage.setItem('token', token);
        console.log(token);
        sessionStorage.setItem('userId', userData.userId);
        sessionStorage.setItem('name', userData.name);
        return userData;
      }
    );
  }

  isLoggedIn(){
    let user= sessionStorage.getItem('username');
    console.log("------------"+user);
    console.log(sessionStorage.getItem('token'));
    
    
    return !(user==null);
  }

  logout(){
    sessionStorage.removeItem('username');
  }


}

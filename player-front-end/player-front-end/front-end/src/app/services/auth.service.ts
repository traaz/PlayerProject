import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../models/login';
import { Register } from '../models/register';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  apiUrl = 'http://localhost:8081/user/'
  constructor(private httpClient : HttpClient, private router : Router) {

  }
  loginUser(login : Login){
    return this.httpClient.post(this.apiUrl+"login", login,{responseType: 'text'})
  }
  isAuthenticated(){
    if(localStorage.getItem("token")){
      return true;
    }else{
      return false;
    }
  }
  register(register : Register){
    return this.httpClient.post(this.apiUrl+"add", register,{responseType: 'text'})

  }

  logOut(){
      localStorage.clear();
      this.router.navigate(["/login"])
  }


}

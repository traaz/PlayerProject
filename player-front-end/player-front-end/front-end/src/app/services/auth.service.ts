import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../models/login';
import { Register } from '../models/register';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  apiUrl = 'http://localhost:8081/user/'
  constructor(private httpClient : HttpClient) {

  }
  loginUser(login : Login){
    return this.httpClient.post(this.apiUrl+"login", login)
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
}

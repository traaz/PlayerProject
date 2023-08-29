import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../models/login';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  flag : boolean = false;
  apiUrl = 'http://localhost:8081/user/'
  constructor(private httpClient : HttpClient) {

  }
  loginUser(login : Login){
    this.flag = true
    return this.httpClient.post(this.apiUrl+"login", login)
  }
  isAuthenticated(){
    if(localStorage.getItem("token")){
      return true;
    }else{
      return false;
    }
  }
}

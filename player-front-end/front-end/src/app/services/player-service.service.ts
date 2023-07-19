import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Player } from '../models/player';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlayerServiceService {
  apiUrl = 'http://localhost:8081/players/getall'
  constructor(private httpClient : HttpClient) {

  }
  getPlayers():Observable<Player[]>{
    return this.httpClient.get<Player[]>(this.apiUrl);
  }

}

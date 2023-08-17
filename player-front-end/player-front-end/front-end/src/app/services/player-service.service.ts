import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Player} from '../models/player';
import { Observable } from 'rxjs';
import { CreatePlayer } from '../models/CreatePlayer';



@Injectable({
  providedIn: 'root'
})
export class PlayerServiceService {
  apiUrl = 'http://localhost:8081/players/'
  constructor(private httpClient : HttpClient) {

  }
  getPlayers():Observable<Player[]>{
    let newPath= this.apiUrl + "getall"
    return this.httpClient.get<Player[]>(newPath);
  }
  getPlayersByTeam(teamId:number):Observable<Player[]>{
    let newPath = this.apiUrl + "team/" + teamId
    return this.httpClient.get<Player[]>(newPath);
  }
  getPlayersByPosition(positionId:number):Observable<Player[]>{
    let newPath = this.apiUrl + "position/" + positionId
    return this.httpClient.get<Player[]>(newPath);
  }
  add(player: CreatePlayer):Observable<Object>{
    return this.httpClient.post(this.apiUrl+"add", player)
  }
  delete(playerId : number):Observable<Object>{
    return this.httpClient.delete(this.apiUrl + playerId)
  }

}

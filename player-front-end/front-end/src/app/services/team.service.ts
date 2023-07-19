import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Team } from '../models/team';

@Injectable({
  providedIn: 'root'
})
export class TeamService {
  apiUrl = 'http://localhost:8081/teams/getall';
  constructor(private httpClient: HttpClient) { }
  getTeams():Observable<Team[]>{
    return this.httpClient.get<Team[]>(this.apiUrl);
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Position } from '../models/position';

@Injectable({
  providedIn: 'root'
})
export class PositionService {
  apiUrl = 'http://localhost:8081/positions/'
  constructor(private httpClient : HttpClient) { }

  getPosition():Observable<Position[]>{
    let newPath= this.apiUrl + "getall"
    return this.httpClient.get<Position[]>(newPath);
  }
}

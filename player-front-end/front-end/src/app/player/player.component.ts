import { Component, OnInit } from '@angular/core';
import { Player } from '../models/player';
import { PlayerServiceService } from '../services/player-service.service';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {
  players : Player[] = [];
  constructor(private playerService: PlayerServiceService) { }

  ngOnInit(): void {
    this.getPlayers();
  }
  getPlayers(){
    this.playerService.getPlayers().subscribe(response => {
      this.players = response
    })
  }

}

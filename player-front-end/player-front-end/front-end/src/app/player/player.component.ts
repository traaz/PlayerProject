import { Component, OnInit } from '@angular/core';
import { Player } from '../models/player';
import { PlayerServiceService } from '../services/player-service.service';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Position } from '../models/position';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {

  players : Player[] = [];
  filterText = "";
  constructor(private playerService: PlayerServiceService,
    private activatedRoute : ActivatedRoute, private toastrService : ToastrService) { } //parametreyi okumak icin urlden

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      if(params["teamId"]){ //teamId approutingmodeldeki gibi ayni olmali
        this.getPlayersByTeam(params["teamId"])
      }else if(params["positionId"]){
        this.getPlayersByPosition(params["positionId"])
      }
      else{
        this.getPlayers()
      }
    })
  }
  getPlayers(){
    this.playerService.getPlayers().subscribe(response => {
      this.players = response
    })
  }
  getPlayersByTeam(teamId : number){
    this.playerService.getPlayersByTeam(teamId).subscribe(response => {
      this.players = response
    })
  }
  getPlayersByPosition(positionId : number) {
    this.playerService.getPlayersByPosition(positionId).subscribe(response => {
      this.players = response
    })
  }
  delete(playerId : number){
    this.playerService.delete(playerId).subscribe(
      response =>{

        this.toastrService.success("Oyuncu Silindi");
        this.getPlayers();
      }
    )
  }






}

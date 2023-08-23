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
  p: number = 1;
  players : Player[] = [];
  filterText = "";
  name : String = "";
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
      for(var player of this.players){
        this.name = player.teamName
      }
    })
  }
  getPlayersByPosition(positionId : number) {
    if(positionId == 1){
      this.name = "Kaleci"
    }
    else if(positionId == 2){
      this.name = "Defans"

    }
    else if ( positionId == 3){
      this.name = "Orta Saha"

    }
    else if( positionId == 4){
      this.name = "Forvet"

    }
    this.playerService.getPlayersByPosition(positionId).subscribe(response => {
      this.players = response

    })
  }
  delete(playerId : number){
    this.playerService.delete(playerId).subscribe(
      response =>{

        this.toastrService.success("Oyuncu Silindi");

        this.activatedRoute.params.subscribe(params => {   //silme islemi yaptıktan liste rastgele resfres olmamalı ayni sayfada kalmali
          if(params["teamId"]){
            this.getPlayersByTeam(params["teamId"])
          }else if(params["positionId"]){
            this.getPlayersByPosition(params["positionId"])
          }
        })
      }
    )
  }






}

import { Component, OnInit } from '@angular/core';
import { Team } from '../models/team';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Position } from '../models/position';
import { PlayerServiceService } from '../services/player-service.service';
import { PositionService } from '../services/position.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { TeamService } from '../services/team.service';
import { Player } from '../models/player';
import { UpdatePlayer } from '../models/UpdatePlayer';

@Component({
  selector: 'app-player-update',
  templateUrl: './player-update.component.html',
  styleUrls: ['./player-update.component.css']
})
export class PlayerUpdateComponent implements OnInit {
  player : Player
  updatePlayer : UpdatePlayer
  teams :Team[]=[]
  positions : Position[]= []
  playerUpdateForm : FormGroup;
  constructor(private toastrService: ToastrService,private positionService :  PositionService,private teamService : TeamService,private formBuilder : FormBuilder,private playerService : PlayerServiceService,private activatedRoute : ActivatedRoute,) { }

  ngOnInit(): void {
    this.teamService.getTeams().subscribe(response =>{
      this.teams = response
    });
    this.positionService.getPosition().subscribe(response =>{
      this.positions = response
    }) ;

    this.activatedRoute.params.subscribe(params => {
      if(params["playerId"]){
        this.getPlayerById(params["playerId"])
      }

    })
    this.updatePlayerForm();

  }
  updatePlayerForm(){
    this.playerUpdateForm = this.formBuilder.group(
      {

        name:["", Validators.required],
        surname:["", Validators.required],
        team:["", Validators.required],
        position:["", Validators.required]
      }
    )
  }
  getPlayerById(playerId : number){
    this.playerService.getPlayersById(playerId).subscribe(response=>{

      this.player = response

      console.log(this.player)
    })
  }
  update(playerId : number){
    if(this.playerUpdateForm.valid){
    let updatePlayer = {id:this.player.id,name : this.player.name, surname:this.player.surname,  teamId:this.playerUpdateForm.value.team, positionId: this.playerUpdateForm.value.position}
    this.playerService.update(playerId, updatePlayer).subscribe(response =>{
      this.toastrService.success("Oyunucu Bilgileri Güncellendi")
      this.playerUpdateForm.reset();
    })
  }else{
    this.toastrService.info("İlgili Alanları Doldurunuz")
  }
  }


}

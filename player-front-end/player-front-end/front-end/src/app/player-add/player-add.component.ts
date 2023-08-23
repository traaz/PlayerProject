import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, FormControl, Validators} from '@angular/forms';
import { PlayerServiceService } from '../services/player-service.service';
import { TeamService } from '../services/team.service';
import { Team } from '../models/team';
import { TeamComponent } from '../team/team.component';
import { Position } from '../models/position';
import { PositionService } from '../services/position.service';
import { Player } from '../models/player';
import { CreatePlayer } from '../models/CreatePlayer';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';



@Component({
  selector: 'app-player-add',
  templateUrl: './player-add.component.html',
  styleUrls: ['./player-add.component.css']
})
export class PlayerAddComponent implements OnInit {
  playerAddForm : FormGroup;
  teams :Team[]=[]
  positions : Position[]= []
  constructor(private formBuilder : FormBuilder, private playerService : PlayerServiceService, private teamService : TeamService,
    private positionService: PositionService,
    private router : Router,
    private toastrService: ToastrService) { }

  ngOnInit(): void {
     this.teamService.getTeams().subscribe(response =>{
      this.teams = response
    });
    this.positionService.getPosition().subscribe(response =>{
      this.positions = response
    })

    this.createPlayerForm();
  }

  createPlayerForm(){
    this.playerAddForm = this.formBuilder.group(
      {
        name:["", Validators.required],
        surname:["", Validators.required],
        team:["", Validators.required],
        position:["", Validators.required]
      }
    )
  }
  add(){
    if(this.playerAddForm.valid){
      let playerAdd  = {name: this.playerAddForm.value.name, surname:this.playerAddForm.value.surname, teamId:this.playerAddForm.value.team, positionId:this.playerAddForm.value.position}
      //let playerModel = Object.assign({},this.playerAddForm.value)
      //console.log(playerAdd)
      //console.log(this.playerAddForm.value.name)
      console.log(this.playerAddForm.value.team)
      this.playerService.add(playerAdd).subscribe(response=>{
        this.toastrService.success("Oyuncu Eklendi", "Başarılı")
        this.playerAddForm.reset()

      },responseError =>{
        console.log(playerAdd)
        this.toastrService.error("Oyuncu Listede Mevcut", "Hata")
      }

      ); //subscribe cunku observable

    }else{
      this.toastrService.info("İlgili Alanları Doldurunuz")
    }


  }

}

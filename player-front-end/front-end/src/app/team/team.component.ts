import { Component, OnInit } from '@angular/core';
import { TeamService } from '../services/team.service';
import { Team } from '../models/team';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {
  teams : Team[] = []
  constructor(private teamService : TeamService) { }

  ngOnInit(): void {
    this.getTeams();
  }
  getTeams(){
    this.teamService.getTeams().subscribe(response => {
      this.teams = response
    })
  }

}

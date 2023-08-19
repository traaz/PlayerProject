import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlayerComponent } from './player/player.component';
import { PlayerAddComponent } from './player-add/player-add.component';
import { PlayerUpdateComponent } from './player-update/player-update.component';

const routes: Routes = [
  {path:"", component:PlayerComponent},
  {path:"players", component:PlayerComponent},
  {path:"players/team/:teamId", component:PlayerComponent},
  {path:"players/position/:positionId", component:PlayerComponent},
  {path:"players/add", component:PlayerAddComponent},
  {path:"players/:playerId", component:PlayerUpdateComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

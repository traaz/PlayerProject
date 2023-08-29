import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlayerComponent } from './player/player.component';
import { PlayerAddComponent } from './player-add/player-add.component';
import { PlayerUpdateComponent } from './player-update/player-update.component';
import { LoginComponent } from './login/login.component';
import { LoginGuard } from './guards/login.guard';

const routes: Routes = [
  {path:"", component:PlayerComponent, canActivate:([LoginGuard])},
  {path:"login", component:LoginComponent},
  {path:"players", component:PlayerComponent,  canActivate:([LoginGuard])},
  {path:"players/team/:teamId", component:PlayerComponent, canActivate:([LoginGuard])},
  {path:"players/position/:positionId", component:PlayerComponent, canActivate:([LoginGuard])},
  {path:"players/add", component:PlayerAddComponent, canActivate:([LoginGuard])},
  {path:"players/:playerId", component:PlayerUpdateComponent,  canActivate:([LoginGuard])}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-navi',
  templateUrl: './navi.component.html',
  styleUrls: ['./navi.component.css']
})
export class NaviComponent implements OnInit {

  constructor(public authService : AuthService, private toastrService: ToastrService) { }

  ngOnInit(): void {
  }
  logOut(){
      this.authService.logOut();
      this.toastrService.info("Çıkış Yapıldı")
    }
  }



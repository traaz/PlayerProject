import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginFormGroup : FormGroup;

  constructor(private formBuilder : FormBuilder, private authService : AuthService,private toastrService: ToastrService,
    private router : Router,
    ) { }

  ngOnInit(): void {
    this.loginForm()
  }
  loginForm(){
    this.loginFormGroup = this.formBuilder.group(
      {
        name:["", Validators.required],
        password:["", Validators.required]

      }
    )
  }
  login(){
    if(this.loginFormGroup.valid){
      let login = {name : this.loginFormGroup.value.name , password:this.loginFormGroup.value.password}
      this.authService.loginUser(login).subscribe(response =>{
        this.toastrService.success("Giriş Başarılı")
        localStorage.setItem("token",response)
        this.router.navigate(['/players'])

      },responseError =>{
        this.toastrService.error("Hatalı Giriş")
        this.loginFormGroup.reset()


      }
      )
    }
    else{
      this.toastrService.info("İlgili alanları doldurunuz.")
    }
  }

}

import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerFormGroup : FormGroup;

  constructor(private formBuilder : FormBuilder, private authService : AuthService,private toastrService: ToastrService,
    private router : Router,
    ) { }

  ngOnInit(): void {
    this.registerForm()
  }
  registerForm(){
    this.registerFormGroup = this.formBuilder.group(
      {
        name:["", Validators.required],
        password:["", Validators.required],
        passwordAgain:["", Validators.required]
      }
    )
  }
  register(){
    if(this.registerFormGroup.valid && this.registerFormGroup.value.password == this.registerFormGroup.value.passwordAgain){
      let register = {name : this.registerFormGroup.value.name , password:this.registerFormGroup.value.password}
      this.authService.register(register).subscribe(response =>{
        this.toastrService.success("Kayit Basarili")

        this.router.navigate(['/login'])

      },responseError =>{
        this.toastrService.error("Kullanici Mevcut")
        this.registerFormGroup.reset()


      }
      )
    }
    else if(this.registerFormGroup.value.password != this.registerFormGroup.value.passwordAgain){
      this.toastrService.error("Şifreler Eşleşmedi")
      this.registerFormGroup.reset()
    }
    else{
      this.toastrService.info("İlgili alanları doldurunuz.")
    }
  }

}

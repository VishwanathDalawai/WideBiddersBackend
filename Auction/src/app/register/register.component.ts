import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { ToastrService } from 'ngx-toastr';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { passValidator } from './validator';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  form = new FormGroup({
    fullName: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.required, Validators.email]),
    phoneNumber: new FormControl('', [Validators.required, Validators.pattern("[1-9]{1}[0-9]{9}")]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)]),
    cnfpass: new FormControl('', [Validators.required, passValidator])
  })


  url1 = environment.apiBaseUrl + "addCustomer/";

  fullName: string;
  email: string;
  phoneNumber: string;
  password1: string;
  password2: string;

  user: any;
  a: any;
  Data: any;
  response: any;


  constructor(private http: HttpClient, private router: Router, private toastr: ToastrService) { }

  onUploadChange(evt: any) {
    const file = evt.target.files[0];

    if (file) {
      const reader = new FileReader();

      reader.onload = this.handleReaderLoaded.bind(this);
      this.a = reader.readAsBinaryString(file);

    }
  }
  handleReaderLoaded(e) {
    this.Data = btoa(e.target.result);

  }


  ngOnInit() {
  }

  register() {
    this.user =
      {
        "customerName": this.fullName, "phoneNumber": this.phoneNumber, "emailId": this.email,
        "password": this.password1
      };

    let obs = this.http.post(this.url1, this.user);
    obs.subscribe((response) => {
      this.response = response;

      if (this.response == 0) {
        this.toastr.success('You have registered successfully', 'Sucess');

        this.router.navigate(["/home"]);
      }
      else if (this.response == -1) { //if the email id already exists
        this.toastr.error('Email id already exists..', 'Error');
      }


    })

  }
}

import { Component, OnInit, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { CustomerService } from '../customer.service';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  url1 = environment.apiBaseUrl + "customerLogin/";
  url2 = environment.apiBaseUrl + "customerEmail/";

  userName: string;
  password: string;
  custId: any;
  data: any;
  loggedin: any;
  credential: any;

  status: boolean = true;
  customerName: any;
  constructor(private router: Router, private http: HttpClient, private customerService: CustomerService, private toastr: ToastrService) { }

  ngOnInit() {
  }


  login() {

    this.credential = {
      "emailId": this.userName, "password": this.password
    };


    let obs = this.http.post(this.url1, this.credential);

    obs.subscribe((response) => {

      this.data = response;

      if (response != -1) {

        let obs2 = this.http.get(this.url2 + this.userName);

        obs2.subscribe((response1) => {
          this.loggedin = response1;

          sessionStorage.setItem('custId', this.data);
          sessionStorage.setItem('emailId', this.userName);
          sessionStorage.setItem('customerName', this.loggedin.UserName);

          this.toastr.success('You have loggedin successfully', 'Sucess');
          this.router.navigate([""]);

        })

      }
      else {  //if the username and password is not matching
        this.toastr.error('Incorrect Username/Password', 'Error');
        this.router.navigate(["login"]);
      }
    })



  }

}

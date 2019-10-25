import { Component, OnInit, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userName:string="";
  password:string="";

credential:any;
status:boolean=true;
  constructor(private router: Router,private http:HttpClient) { }

  ngOnInit() {
  }


  login(){
   
this.credential = {
  "emailId":this.userName, "password":this.password
};
console.log(this.credential);

let obs =  this.http.post("http://localhost/customerLogin/",this.credential);

obs.subscribe((response)=>{
  
  this.status=false;
  console.log(response);
     if(response!=null){
       if(response==true){
         this.status=true;
     this.router.navigate(["home",this.credential.emailId]);
    

       }
       else{
         this.status=false;
         this.router.navigate(["login"]);
       }
     }
    })


   
  }
  /* public getEmail():string{
    if(this.status==true){
     // this.credential.stroreData();
     return this.credential.userName;
    }
    else{
      return "";
    }
  } */

}

import { Component, OnInit } from '@angular/core';
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
status:boolean=false;
  constructor(private router: Router,private http:HttpClient) { }

  ngOnInit() {
  }


  login(){
this.credential = {
  "userName":this.userName, "password":this.password
};
console.log(this.credential);

let obs =  this.http.post("http://192.168.2.35:80/addCustomer/",this.credential);
obs.subscribe((response)=>{
     if(response!=null){
       if(response==true){
         this.status=true;
       }
       else{
         this.status=false;
       }
     }
    })


    this.router.navigate(["home"]);
  }

}

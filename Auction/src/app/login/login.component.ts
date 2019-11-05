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

  url1=environment.apiBaseUrl + "customerLogin/";
  url2=environment.apiBaseUrl + "customerEmail/";

  userName:string="ddd@gmail.com";
  password:string="dddddd";
 custId:any;
  data:any;
loggedin:any;
credential:any;

status:boolean=true;
  customerName: any;
  constructor(private router: Router,private http:HttpClient,private customerService:CustomerService,private toastr: ToastrService) { }

  ngOnInit() {
  }


  login(){
   
this.credential = {
  "emailId":this.userName, "password":this.password
};



 //  this.customerService.add("16");
 //  this.customerService.clear();


// console.log(this.credential);

let obs =  this.http.post(this.url1,this.credential);

obs.subscribe((response)=>{
  
this.data=response;
//  this.status=false;

 // console.log(response);
     if(response!=-1){

      let obs2 =  this.http.get(this.url2 + this.userName);

      obs2.subscribe((response1)=>{
        this.loggedin = response1;
        console.log("login response");
        console.log(this.loggedin.UserName);

    //  this.customerName=response1;

      sessionStorage.setItem('custId',this.data);
      sessionStorage.setItem('emailId',this.userName);
      sessionStorage.setItem('customerName',this.loggedin.UserName);

      this.toastr.success('You have loggedin successfully', 'Sucess');
 this.router.navigate([""]);

      })
      
    //   if(response==true){
    //     this.status=true;


/* important

    this.customerService.setCustomer(this.data);
this.custId=this.customerService.getCustomer();
*/



// console.log("customer id" + sessionStorage.getItem('custId'));


// console.log(this.custId);

 //    this.router.navigate(["home",this.credential.emailId]);
 

 //      }
   /*    else{
         this.status=false;
         this.router.navigate(["login"]);
       } */
     }
     else{
      this.toastr.error('Incorrect Username/Password', 'Error');
      this.router.navigate(["login"]);
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

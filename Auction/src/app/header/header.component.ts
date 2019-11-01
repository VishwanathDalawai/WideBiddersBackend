import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CustomerService } from '../customer.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  url1=environment.apiBaseUrl + "getCustEmail/";
  

  param:any;
  userName:any;
  email:any;
  product_name:string="";
  custId:any;
  emailId:string;
  data:any;
  Email:any;


  // @Input() loggedIn:string;
  
   //  static counter:number=0;
  constructor(private router:Router, private activate:ActivatedRoute, private route: ActivatedRoute,private customerService:CustomerService,private http:HttpClient){
  this.param=this.router.url;

  }

  ngOnInit() {

    /* important
    this.custId=this.customerService.getCustomer();
    console.log("customerId:" + this.custId);
  
*/

 this.custId = sessionStorage.getItem('custId');

console.log("header component" + this.custId);

    if(this.custId!=null){
   //   console.log("header component::::id:" + this.custId);
      this.emailId = sessionStorage.getItem('emailId');
   //   console.log("header component::::emailid:" + this.emailId);
      
      
// let obs =  this.http.get(this.url1 + this.custId);
/* important important
this.http.post(this.url1 , this.custId).subscribe((Response)=>{
  console.log("hey");
  console.log(Response);
  this.data=Response['MailID'];

this.emailId=this.data;


  console.log(this.data);
  
    })  */
   }



    
  //  console.log(HeaderComponent.counter);
   /* if(HeaderComponent.counter == 0){

    console.log("illi");
    this.email = this.route.snapshot.paramMap.get('email');
    HeaderComponent.counter++;
    
    if(this.email != null){
    console.log("from headfer");
    console.log(this.email);
    this.router.navigate(['home']);
  /* this.userName = this.user.getEmail();
   if(this.userName==""){
     console.log("not logged in");
   }
   else{
     console.log(this.userName);
   } 
    }
  }  */
  }
  sell(){

    if(this.custId!=null){
      this.router.navigate(["sell"]);

    }
    else{
      this.router.navigate(["login"]);
    }    
  }
  signup(){
    this.router.navigate(["register"]);
  }
  login(){
    this.router.navigate(["login"]);
  }


search(){
  this.router.navigate(['productName',this.product_name]);
}





  car(){
    this.router.navigate(['categoryDetails','car']);
  }
  mobile(){
    this.router.navigate(['categoryDetails','mobile']);
  }
  furniture(){
    this.router.navigate(['categoryDetails','furniture']);
  }

  fashion(){
    this.router.navigate(['categoryDetails','fashion']);
  }

  bikes(){
    this.router.navigate(['categoryDetails','bikes']);
  }

  books(){
    this.router.navigate(['categoryDetails','books']);
  }

  electronics(){
    this.router.navigate(['categoryDetails','electronics']);
  }
  clear(){
    sessionStorage.clear();
 //   console.log("header component::::id:" + this.custId);
 //  console.log("header component::::emailid:" + this.emailId);
  }



}

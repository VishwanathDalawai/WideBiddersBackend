import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router} from '@angular/router';
import { environment } from 'src/environments/environment';
import { ToastrService } from 'ngx-toastr';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {


  form = new FormGroup({
    fullName : new FormControl('',Validators.required),
    email : new FormControl('',[Validators.required,Validators.email]),
    phoneNumber : new FormControl('',[Validators.required,Validators.pattern("[789][0-9]{9}")]),
    password1 : new FormControl('',[Validators.required,Validators.minLength(6)]),
    password2 : new FormControl('',Validators.required)
    
  })





  url1=environment.apiBaseUrl + "addCustomer/";

  fullName:string="Deekshith";
  email:string="ddd@gmail.com";
  phoneNumber:string="8971158773";
  password1:string="dddddd";
  password2:string="dddddd";
  
  user:any;
  a:any;
  Data:any;
  response:any;
 
  




  constructor(private http:HttpClient,private router:Router, private toastr: ToastrService) { }

  onUploadChange(evt: any) {
    const file = evt.target.files[0];
  
    if (file) {
      const reader = new FileReader();
  
      reader.onload = this.handleReaderLoaded.bind(this);
      this.a= reader.readAsBinaryString(file);
      console.log("Read as binary String "+this.a);
    }
  }
  handleReaderLoaded(e) {
  this.Data = btoa(e.target.result);
 // this.Data.push(btoa(e.target.result));
  }


  ngOnInit() {
    
  }



  register(){


    
    this.user = 
       {
       "customerName": this.fullName, "phoneNumber": this.phoneNumber , "emailId": this.email ,
       "password": this.password1
       //"userImage":this.Data
       //,{"productImage":this.Data[1]},{"productImage":this.Data[2]},{"productImage":this.Data[3]},{"productImage":this.Data[4]}
      
      };
      
    
    console.log("image passed"+this.Data);
  
    
       let obs =  this.http.post(this.url1,this.user);
       obs.subscribe((response)=>{
            this.response = response;

            console.log("response from email" + this.response);

            if(this.response == 0){
              this.toastr.success('You have registered successfully', 'Sucess');
  
              this.router.navigate(["/home"]);
             }
             else if (this.response == -1){
              this.toastr.error('Email id already exists..', 'Error');
             }
            

           })

     
          
  //  this.router.navigate(["userAdded"]);
 

 /* this.toastr.success('Successful','Success');
   this.router.navigate(["/home"]); */
  }


}

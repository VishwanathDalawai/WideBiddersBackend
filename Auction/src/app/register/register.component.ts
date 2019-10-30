import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router} from '@angular/router';
import { environment } from 'src/environments/environment';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  url1=environment.apiBaseUrl + "addCustomer/";

  fullName:string="";
  email:string="";
  phoneNumber:string="";
  password1:string="";
  password2:string="";
  
  user:any;
  a:any;
  Data:any;
  
 
  



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
<<<<<<< HEAD
    
=======
   
   
>>>>>>> branch 'master' of https://github.com/Vishwanathpd/WideBiddersBackend.git
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
       obs.subscribe(()=>{
            
           })

<<<<<<< HEAD
          
   this.router.navigate(["userAdded"]);
   
=======
     
           
           this.toastr.success('You have registered successfully', 'Sucess');

           this.router.navigate(["/home"]);
  //  this.router.navigate(["userAdded"]);
 

 /* this.toastr.success('Successful','Success');
   this.router.navigate(["/home"]); */
>>>>>>> branch 'master' of https://github.com/Vishwanathpd/WideBiddersBackend.git
  }


}

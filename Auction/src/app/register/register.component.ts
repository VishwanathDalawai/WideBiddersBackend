import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  fullName:string="";
  email:string="";
  phoneNumber:string="";
  password1:string="";
  password2:string="";
  
  user:any;
  a:any;
  Data:any;
  
 
  



  constructor(private http:HttpClient,private router:Router) { }
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
       "password": this.password1,"userImage":this.Data
       //,{"productImage":this.Data[1]},{"productImage":this.Data[2]},{"productImage":this.Data[3]},{"productImage":this.Data[4]}
      
      };
      
    
    console.log("image passed"+this.Data);
   
       let obs =  this.http.post("http://192.168.2.35:80/addCustomer/",this.user);
       obs.subscribe(()=>{
            
           })

          
    this.router.navigate(["userAdded"]);
  }

}

import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  param:any;
  userName:any;
  email:any;
  product_name:string="";

  @Input() loggedIn:string;
  
   //  static counter:number=0;
  constructor(private router:Router, private activate:ActivatedRoute, private route: ActivatedRoute){
  this.param=this.router.url;

  }

  ngOnInit() {
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
    this.router.navigate(["sell"]);
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



}

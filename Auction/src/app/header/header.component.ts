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





}

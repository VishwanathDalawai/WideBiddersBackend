import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-myproducts',
  templateUrl: './myproducts.component.html',
  styleUrls: ['./myproducts.component.css']
})
export class MyproductsComponent implements OnInit {

  url1=environment.apiBaseUrl + "productByCustomerId/";

data:any;
custId:any;

  constructor(private http:HttpClient,private activate:ActivatedRoute, private router:Router,private customerService:CustomerService) { }

  ngOnInit() {
    this.custId=this.customerService.getCustomer();
 
    console.log(this.custId);
  
      let obs = this.http.get(this.url1 + this.custId);
      obs.subscribe((response) => {
  
        this.data = response;
       
   
  
      }
  
      )
  }

}

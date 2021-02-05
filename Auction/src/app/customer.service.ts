import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private router:Router) { }

  customerId:string="";
 // customerId: string[] = [];

  setCustomer(customer: string) {
   // this.customerId.push(customer);
   this.customerId=customer;
  }

  clear() {
  //  this.customerId = [];
  console.log("clear called");
  this.customerId ="";
  
  
  }
  getCustomer():string{
    return this.customerId;
  }
 

}

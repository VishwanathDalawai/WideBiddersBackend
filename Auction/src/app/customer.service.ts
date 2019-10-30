import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor() { }

  customerId:string="";
 // customerId: string[] = [];

  setCustomer(customer: string) {
   // this.customerId.push(customer);
   this.customerId=customer;
  }

  clear() {
  //  this.customerId = [];
  this.customerId ="";
  }
  getCustomer():string{
    return this.customerId;
  }
 

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-congrats',
  templateUrl: './congrats.component.html',
  styleUrls: ['./congrats.component.css']
})
export class CongratsComponent implements OnInit {
  custId: any;
  constructor(private router: Router, private customerService: CustomerService) { }

  ngOnInit() {
    this.custId = this.customerService.getCustomer();

  }
  goHome() {

    setTimeout(() => {
      this.router.navigate(["home"]);
    },
      4000);


  }

}

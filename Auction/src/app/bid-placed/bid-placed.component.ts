import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bid-placed',
  templateUrl: './bid-placed.component.html',
  styleUrls: ['./bid-placed.component.css']
})
export class BidPlacedComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  goHome() {


    setTimeout(() => {
      this.router.navigate(["home"]);
    }, 2000);



  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-added',
  templateUrl: './user-added.component.html',
  styleUrls: ['./user-added.component.css']
})
export class UserAddedComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  goHome() {
    this.router.navigate(["home"]);
  }

}

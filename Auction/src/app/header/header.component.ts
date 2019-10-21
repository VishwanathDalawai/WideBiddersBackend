import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  param:any;
  constructor(private router:Router, private activate:ActivatedRoute){
  this.param=this.router.url;
  }

  ngOnInit() {
  }
  sell(){
    this.router.navigate(["sell"]);
  }


}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  url2=environment.apiBaseUrl + "productId/";

  productId: any;
  data: any;

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private router:Router
   
  ) { }


  getProductDetail() {

  }


  ngOnInit() {
    this.productId = this.route.snapshot.paramMap.get('id');
    
    let obs = this.http.get(this.url2 + this.productId);
    obs.subscribe((response) => {

      this.data = response;
     
 

    }

    )
  }
  placed(){
    this.router.navigate(["bidplaced"]);
  }
 
}



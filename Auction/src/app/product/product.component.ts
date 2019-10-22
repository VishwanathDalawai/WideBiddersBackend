import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  productId: any;
  data: any;

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient

  ) { }


  getProductDetail() {

  }


  ngOnInit() {
    this.productId = this.route.snapshot.paramMap.get('id');

    let obs = this.http.get("http://localhost/productId/"+this.productId);
    obs.subscribe((response) => {

      this.data = response;
     
  // console.log(this.data);
 

    }

    )
  }

}



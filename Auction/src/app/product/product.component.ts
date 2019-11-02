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

  url1=environment.apiBaseUrl + "placeBid/";
  
  custId:any;
  productId: any;
  data: any;
  bidDetails:any;
  bidAmount:any;

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
      console.log(this.data);
      console.log(this.data.customer)
      console.log(this.data.customer.customerName);
      console.log(this.data.productModel);
      console.log(this.data.customer.customerName.toLowerCase( ))
   }
    )
  }




  placeBid(){


    this.custId=sessionStorage.getItem('custId');


    this.bidDetails = 
    {
     "productId": this.productId,"bidderCustomerId": this.custId,
      "bidAmount": this.bidAmount , "dateTime": "dateTime"

   };
let obs1 =  this.http.post(this.url1,this.bidDetails);
       obs1.subscribe((response)=>{

           })
    this.router.navigate(["bidplaced"]);
  }
 
}



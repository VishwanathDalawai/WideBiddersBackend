import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-product-name',
  templateUrl: './product-name.component.html',
  styleUrls: ['./product-name.component.css']
})
export class ProductNameComponent implements OnInit {
  url2=environment.apiBaseUrl + "productByProductName/";
  url5=environment.apiBaseUrl + "getBidAmount/";
  data:any;
  productName:any;
  currentBidPrice: any;
  
  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private router:Router
  ) { }

  ngOnInit() {
    this.productName = this.route.snapshot.paramMap.get('name');
 
 console.log(this.productName);

    let obs = this.http.get(this.url2 + this.productName);
    obs.subscribe((response) => {

      this.data = response;


      for(let item of this.data){
        console.log(item);
        console.log(item.productId);
        let obs6 = this.http.get(this.url5 + item.productId);
      obs6.subscribe((response1) => {
    console.log("updated" + response1);
        this.currentBidPrice = response1;
        if(this.currentBidPrice == 0){
          this.currentBidPrice = item.startingBidPrice;
         
        }
        else{
          this.currentBidPrice = response1;
        }
        item.startingBidPrice = this.currentBidPrice;
      
      // console.log("bid amount is :" +  this.currentBidPrice);
      
     }
      )
      console.log(this.currentBidPrice);
      }
     
 

    }

    )


}

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-category-details',
  templateUrl: './category-details.component.html',
  styleUrls: ['./category-details.component.css']
})
export class CategoryDetailsComponent implements OnInit {

  url2=environment.apiBaseUrl + "productByCategory/";
  url5=environment.apiBaseUrl + "getBidAmount/";
data:any;
categoty:any;
currentBidPrice: any;

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private router:Router
  ) { }

  ngOnInit() {
    

    this.route.queryParamMap.subscribe((paramMap: ParamMap) => {
      const refresh = paramMap.get('refresh');
      if (refresh) {
        this.fetchData();
      }
    });




   
}

fetchData(){
  this.categoty = this.route.snapshot.paramMap.get('category');
  
 
  console.log(this.categoty);

    let obs = this.http.get(this.url2 + this.categoty);
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

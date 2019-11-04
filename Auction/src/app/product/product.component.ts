import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  url2=environment.apiBaseUrl + "productId/";

  url1=environment.apiBaseUrl + "placeBid/";

  url3=environment.apiBaseUrl + "getBidDetailsByProductId/";

  url4=environment.apiBaseUrl + "customerDetails/";

  url5=environment.apiBaseUrl + "getBidAmount/";
  
  custId:any;
  productId: any;
  data: any;
  bidDetails:any;
  bidAmount:any;
  currentBidPrice:any;
  history:any;
  customerDetail:any;
  bidderCustId:any;
  startingProductPrice:any;
  nextBidPrice:any;
  incrementPrice:any;

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private router:Router,
    private toastr: ToastrService
   
  ) { }


  getProductDetail() {

  }


  ngOnInit() {
    this.productId = this.route.snapshot.paramMap.get('id');
    
    let obs = this.http.get(this.url2 + this.productId);
    obs.subscribe((response) => {

      this.data = response;
      this.startingProductPrice = this.data.startingBidPrice;
      this.incrementPrice = this.data.incrementPrice;
 //     console.log(this.data);
   //   console.log(this.data.customer)
    //  console.log(this.data.customer.customerName);
   //   console.log(this.data.productModel);
  //    console.log(this.data.customer.customerName.toLowerCase( ));
    //  this.currentBidPrice = this.data.startingBidPrice;
      this.bidPrice();

   }
    )


    







/* important..... to show the bid details for a perticular project..... */

    let obs2 = this.http.get(this.url3 + this.productId);
    obs2.subscribe((response) => {
console.log("printing history");
      this.history = response;
      
      console.log(this.history);
      
     // console.log("history details" + this.history);
      console.log(this.history);
      console.log("bid amount" + this.history[0].bidAmount);
      console.log("Customer Name" + this.history[0].bidderCustomer.customerName);
      console.log("Date Time" + this.history[0].dateTime);
      
   //  console.log(this.history.bidderCustomerId);
  //   this.bidderCustId = this.history.bidderCustomerId;
   //  console.log(this.history.bidAmount);
   //  console.log(this.history.dateTime);
   }
    )

/*
    let obs3 = this.http.get(this.url4 + this.bidderCustId);
    obs3.subscribe((response) => {

      this.customerDetail = response;
     console.log(this.customerDetail.customerName);
    
   }
    )

*/

  }




bidPrice(){

  let obs6 = this.http.get(this.url5 + this.productId);
  obs6.subscribe((response) => {

    this.currentBidPrice = response;
    if(this.currentBidPrice == 0){
      this.currentBidPrice = this.startingProductPrice;
    }
  
  // console.log("bid amount is :" +  this.currentBidPrice);
  
 }
  )

}




  placeBid(){



    

    this.custId=sessionStorage.getItem('custId');

   
    if(this.custId!=null){

      this.nextBidPrice = this.currentBidPrice + this.incrementPrice;

      if(this.bidAmount >= this.nextBidPrice)
      {



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
          else{
            this.toastr.error('Your bid amount should be greater', 'Error');

          }

          }

          else{
            this.toastr.error('You have to be logged in to place the bid', 'Error');
            this.router.navigate(["login"]);
          }




  }
 
}



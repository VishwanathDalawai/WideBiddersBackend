import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { ToastrService } from 'ngx-toastr';
import { HomeComponent } from '../home/home.component';



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

  url8=environment.apiBaseUrl + "getBidDates/";
  
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
time:any;
productAddedDate:any;
deadline:any;
timer:any;
now:any;
  difference:any;
  seconds:any;
  minutes:any;
  hours:any;
  days:any;
  dateEntered:any;
  dateTime:any;

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private router:Router,
    private toastr: ToastrService,
    private home:HomeComponent
   
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
 
      this.bidPrice();

   }
    )

/*  implemented timer */

    let obs8 = this.http.get(this.url8 + this.productId);
    obs8.subscribe((response) => {
      console.log("auction start date:")
      this.time = response;
  // console.log(this.time.auctionStartDate);
this.productAddedDate = this.time.auctionStartDate;
this.deadline = new Date(this.productAddedDate); 
this.deadline.setDate(this.deadline.getDate() + 7);

this.timer = setInterval(() => {
  this.timeBetweenDates(this.deadline); 
}, 1000);

   }
    )



    







/* important..... to show the bid details for a perticular project..... */

    let obs2 = this.http.get(this.url3 + this.productId);
    obs2.subscribe((response) => {
// console.log("printing history");
      this.history = response;

      for(let item of this.history){

       
        item.hrs = "";
        item.hrs = new Date( item.dateTime);
      }
  //    console.log(this.history);
      
     // console.log("history details" + this.history);
  //    console.log(this.history);
 //     console.log("bid amount" + this.history[0].bidAmount);
  //    console.log("Customer Name" + this.history[0].bidderCustomer.customerName);
   //   console.log("Date Time" + this.history[0].dateTime);
      
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


  timeBetweenDates(toDate) {
 //   console.log("inside function");
    this.dateEntered = toDate;
  
    console.log("Entered date:" + this.dateEntered);
  
    this.now = new Date();
  
  //  console.log("current date:" + this.now);
    this.difference = this.dateEntered.getTime() - this.now.getTime();
//  console.log("difference is" + this.difference);
    if (this.difference <= 0) {
 // console.log("inside if");
      // Timer done
      clearInterval(this.timer);
    
    } else {
  //    console.log("inside else");
      this.seconds = Math.floor(this.difference / 1000);
      this.minutes = Math.floor(this.seconds / 60);
      this.hours = Math.floor(this.minutes / 60);
      this.days = Math.floor(this.hours / 24);
  
  
  
 // console.log("seconds" + this.seconds);
 // console.log("hours" + this.hours);
  
  
      this.hours %= 24;
      this.minutes %= 60;
      this.seconds %= 60;
 
    }
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

/*
this.dateTime = new Date();
this.dateTime = new Date(this.dateTime);
*/
    this.bidDetails = 
    {
     "productId": this.productId,"bidderCustomerId": this.custId,
      "bidAmount": this.bidAmount 

   };
let obs1 =  this.http.post(this.url1,this.bidDetails);
this.toastr.info('please wait', 'your amount is being bid',{extendedTimeOut: 3000})
       obs1.subscribe((response)=>{
        
console.log("response for the bid" + response);
        if(response == -1){
          this.toastr.error('The bid amount has changed..Please reload the page..', 'Error');
        }

         else{
          setTimeout(() =>
          {
            this.router.navigate(["bidplaced"]);
           }, 1000);
  
          }
         
           })

         
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



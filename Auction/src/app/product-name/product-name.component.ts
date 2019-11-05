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
  url8=environment.apiBaseUrl + "getBidDates/";
  data:any;
  productName:any;
  currentBidPrice: any;

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

        item.hrs = "";
        item.dys = "";
        item.mins = "";
        item.secs = "";

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
    //  console.log(this.currentBidPrice);




    let obs8 = this.http.get(this.url8 + item.productId);
    obs8.subscribe((response) => {
      console.log("auction start date:")
      this.time = response;
  // console.log(this.time.auctionStartDate);




  item.startDate = this.time.auctionStartDate;
  item.endDate = new Date(item.startDate); 
  item.endDate.setDate( item.endDate.getDate() + 7);





  /*

this.productAddedDate = this.time.auctionStartDate;
this.deadline = new Date(this.productAddedDate); 
this.deadline.setDate(this.deadline.getDate() + 7);

*/

this.timer = setInterval(() => {
 console.log("inside function");
 this.dateEntered = item.endDate;

 console.log("Entered date:" + this.dateEntered);

 this.now = new Date();

 console.log("current date:" + this.now);
 this.difference = this.dateEntered.getTime() - this.now.getTime();
console.log("difference is" + this.difference);
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



console.log("seconds" + this.seconds);
console.log("hours" + this.hours);


   this.hours %= 24;
   this.minutes %= 60;
   this.seconds %= 60;


   item.hrs = this.hours;
   item.dys = this.days;
   item.mins = this.minutes;
   item.secs = this.seconds;

// this.ngOnInit();
 } 
}, 1000);

   }
    )





      } //end of for loop
     
 

    }

    )


}

}

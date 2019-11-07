import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Injectable } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
@Injectable()
export class HomeComponent implements OnInit {

  url1=environment.apiBaseUrl + "products";

  url5=environment.apiBaseUrl + "getBidAmount/";

  url8=environment.apiBaseUrl + "getBidDates/";

  url9=environment.apiBaseUrl + "timerComplete/";


data:any;
name:any;
item:any
imageData=[];
email:any;
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
custId:any;
wishListDetail:any;


  constructor(private http:HttpClient,private activate:ActivatedRoute) { }
  


  ngOnInit() {
 
    let obs =  this.http.get(this.url1);
    obs.subscribe((response)=>{      
         this.data = response;

         for(let item of this.data){
      
          item.hrs = "";
          item.dys = "";
          item.mins = "";
          item.secs = "";
        
           let obs6 = this.http.get(this.url5 + item.productId);
         obs6.subscribe((response1) => {
     
           this.currentBidPrice = response1;
           if(this.currentBidPrice == 0){ //if the response is zero
             this.currentBidPrice = item.startingBidPrice;
            
           }
           else{
             this.currentBidPrice = response1;
           }
           item.startingBidPrice = this.currentBidPrice;        
        }
         )
     

         let obs8 = this.http.get(this.url8 + item.productId);
         obs8.subscribe((response) => {   
           this.time = response;

     item.productEndDate = this.time.auctionEndDate;
     item.endDate = new Date(item.productEndDate); 
       
     this.timer = setInterval(() => {
      this.dateEntered = item.endDate;
       
      this.now = new Date();
    
      this.difference = this.dateEntered.getTime() - this.now.getTime();
 
      if (this.difference <= 0) {
 
        clearInterval(this.timer);
      
      } else {
   
        this.seconds = Math.floor(this.difference / 1000);
        this.minutes = Math.floor(this.seconds / 60);
        this.hours = Math.floor(this.minutes / 60);
        this.days = Math.floor(this.hours / 24);

        this.hours %= 24;
        this.minutes %= 60;
        this.seconds %= 60;

        item.hrs = this.hours;
        item.dys = this.days;
        item.mins = this.minutes;
        item.secs = this.seconds;

      } 
     }, 1000);
     
        }
         )

 } //end of for

})
}
}

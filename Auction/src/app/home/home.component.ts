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

/*
  product_name:string="";
  product_category:string="";
  product_model:string="";
  product_desc:string="";
  year:string="";
  min_bid_price:string="";
  increment:string="";
  
  product:any;
  ProductImages:any;
  image1:any;
  image2:any;
  image3:any;
  image4:any;
  image5:any;
*/
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


  constructor(private http:HttpClient,private activate:ActivatedRoute) { }
  


  ngOnInit() {
  //  console.log("product image1");
  //  this.email = this.activate.snapshot.paramMap.get('email');
    let obs =  this.http.get(this.url1);
    obs.subscribe((response)=>{
      
         this.data = response;
//console.log("passing object");
//console.log(this.data);
         for(let item of this.data){

       
          item.hrs = "";
          item.dys = "";
          item.mins = "";
          item.secs = "";
          
         //  console.log("product from backend");
       //    console.log(item);
        //   console.log(item.productId);
           let obs6 = this.http.get(this.url5 + item.productId);
         obs6.subscribe((response1) => {
      // console.log("updated" + response1);
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
     //    console.log(this.currentBidPrice);




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




         } //end of for

     //    console.log(this.data);
/*
        

*/


     //    console.log(this.data);
         
     /*    for (var prop in this.data) {
          console.log("Key:" + prop);
          if(this.data[prop].productImage[0]!=undefined)
          {
          console.log("Value:" + this.data[prop].productImage[0].productImage);
          this.imageData.push('data:image/png;base64,'+this.data[prop].productImage[0].productImage);
          }
      } */
  //    console.log("product image2");
  //    console.log(this.data.productImage[0].productImage);
       //  this.imageData.push('data:image/png;base64,' +this.data[11].productImage[0].productImage);

     //    this.name =this.data[1].productName
       //  console.log(this.imageData);
       // console.log(this.data[1].productName);
        //console.log(this.data[11].productImage[0]);
        })
  }


/*


  timeBetweenDates(toDate) {
    console.log("inside function");
    this.dateEntered = toDate;
  
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
 
    }
  }
*/



}

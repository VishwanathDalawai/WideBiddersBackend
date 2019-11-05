import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { CustomerService } from '../customer.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-myproducts',
  templateUrl: './myproducts.component.html',
  styleUrls: ['./myproducts.component.css']
})
export class MyproductsComponent implements OnInit {

  url1=environment.apiBaseUrl + "productByCustomerId/";
  url5=environment.apiBaseUrl + "getBidAmount/";
  url3=environment.apiBaseUrl + "productUpdate/";
  url6=environment.apiBaseUrl + "productId/";
  url9=environment.apiBaseUrl + "deleteProduct/";
  url8=environment.apiBaseUrl + "getBidDates/";

 
details:any;
data:any;
custId:any;
currentBidPrice: any;
updatedDescription:any;
updatingProductId:any;
updatedProduct:any;


updatedProductName:any;
updatedProductModel:any;
updatedProductCategory:any;
updatedProductInitialPrice:any;
updatedProductIncrement:any;
updatedProductYear:any;
updatedProductCustomerId:any;
updatedProductId:any;

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



  constructor(private http:HttpClient,private activate:ActivatedRoute, private router:Router,private customerService:CustomerService,private toastr: ToastrService) { }

  ngOnInit() {
  //  this.custId=this.customerService.getCustomer();
  this.custId = sessionStorage.getItem('custId');
    console.log(this.custId);
  
      let obs = this.http.get(this.url1 + this.custId);
      obs.subscribe((response) => {
  
        this.data = response;
        console.log("data is");
        console.log(this.data);
       
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
   //     console.log(this.currentBidPrice);


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

  update(id : string){
    console.log("update function");
    console.log("inside update Id is:" + id);
    this.updatingProductId = id;

    
  //  this.router.navigate(['/myproduct']);



  }


delete(id:string){
let obs9 = this.http.delete( this.url9 + id);
obs9.subscribe((Response) => {
console.log("product deleted");
this.ngOnInit();
})




// this.router.navigate(['/delete']);


}





  updateProduct(){
    console.log("inside update product: " + this.updatingProductId );
console.log(this.updatedDescription);

let obs = this.http.get(this.url6 + this.updatingProductId);
    obs.subscribe((response) => {

      this.details = response;
      console.log("getting product");
      console.log(this.details);




      this.updatedProductId = this.details.productId;
      this.updatedProductName = this.details.productName;
      this.updatedProductModel = this.details.productModel;
      this.updatedProductCategory = this.details.productCategoryName;
      this.updatedProductInitialPrice = this.details.startingBidPrice;
      this.updatedProductIncrement = this.details.incrementPrice;
      this.updatedProductYear = this.details.productBoughtYear;
      this.updatedProductCustomerId = this.details.customer.customerId; 


/*

console.log(this.details.customer.customerId);
      console.log(this.details.productId);
      console.log(this.details.incrementPrice);
      console.log(this.details.productBoughtYear);
      console.log(this.details.productCategoryName);
      console.log(this.details.productDescription);
      console.log(this.details.productModel);
      console.log(this.details.productName);
      console.log(this.details.productId);
      console.log(this.details.productId);
      console.log(this.details.productId);
      console.log(this.details.productId);
    */
      
this.send();



   }
    ) 


  }



  send(){

    this.updatedProduct = 
    { "customerId":this.updatedProductCustomerId, "productName": this.updatedProductName, "productCategoryName": this.updatedProductCategory, "productModel":this.updatedProductModel , "productDescription":this.updatedDescription,
    "productBoughtYear": this.updatedProductYear, "startingBidPrice":   this.updatedProductInitialPrice , "incrementPrice": this.updatedProductIncrement, "approvalStatus": 1, "reportFlag": 0,
    "productId": this.updatedProductId
   // "productImage":[{"productImage":this.Data[0]},{"productImage":this.Data[1]}
    //,{"productImage":this.Data[1]},{"productImage":this.Data[2]},{"productImage":this.Data[3]},{"productImage":this.Data[4]}
   // ]
   };

console.log("passing json");
console.log(this.updatedProduct);
   let obs7 =  this.http.put(this.url3,this.updatedProduct);
   obs7.subscribe((response)=>{
      // console.log("response" + response);
     //   this.productId = response;
     //   console.log("product id:" +this.productId);
      //  this.auction();

       })

console.log("updated");
this.toastr.success('Product Detail updated successfully..', 'Sucess');
  //  this.router.navigate(['/']);



  }



}

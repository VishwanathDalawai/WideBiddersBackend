import { Component, OnInit } from '@angular/core';

import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Router} from '@angular/router';
import { environment } from 'src/environments/environment';
import { CustomerService } from '../customer.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';





@Component({
  selector: 'app-sell',
  templateUrl: './sell.component.html',
  styleUrls: ['./sell.component.css']
})
export class SellComponent implements OnInit {

  form = new FormGroup({
    productName : new FormControl('',Validators.required),
    product_category : new FormControl('',Validators.required),
    product_model : new FormControl('',Validators.required),
    product_desc :  new FormControl('',Validators.required),
    year : new FormControl('',Validators.pattern("([1]{1}[7-9]{1}[0-9]{2})|([2]{1}[0]{1}[0-1]{1}[0-9]{1})")),
    min_bid_price : new FormControl('',[Validators.required,Validators.pattern("[0-9]*")]),
    increment : new FormControl('',[Validators.required,Validators.pattern("[0-9]*")])
   // check : new FormControl('',Validators.required)
   
  })


url1=environment.apiBaseUrl + "addproduct/";
url2=environment.apiBaseUrl + "addAuctionMaster/";

  productName:string="";
  product_category:string="";
  product_model:string="";
  product_desc:string="";
  year:string="";
  min_bid_price:string="";
  increment:string="";
  auctionMaster:any;
  product:any;
  ProductImages:any;
  image1:any;
  image2:any;
  image3:any;
  image4:any;
  image5:any;

  custId:any;
  Data=[];
  imageData=[];
a:any;
cid:string; 
startDate:any;
endDate:any;
currentDate:any;
productId:any;

  constructor(private http:HttpClient,private router:Router,private customerService:CustomerService){
  }


  onUploadChange(evt: any) {
    const file = evt.target.files[0];
  
    if (file) {
      const reader = new FileReader();
  
      reader.onload = this.handleReaderLoaded.bind(this);
      this.a= reader.readAsBinaryString(file);
      console.log("Read as binary String "+this.a);
    }
  }
  handleReaderLoaded(e) {
 //   this.Data = btoa(e.target.result);
 this.Data.push(btoa(e.target.result));
  }
  
/*
  getProduct(){
    let observable = this.http.get("http://localhost/productss");      //get method of request
        observable.subscribe( (response)=>{
            console.log("getProduct ", response[4].img);
            this.imageData.push('data:image/png;base64,' +response[4].img);
        })
    }
*/


  post(){

/*
    this.ProductImages=[
    {"productImage":this.Data[0]},
    {"productImage":this.Data[1]},
     {"productImage":this.Data[2]},
    {"productImage":this.Data[3]},
    {"productImage":this.Data[4]}
    ];
*/
    //[{"productImage":"hey"}]
    this.custId=sessionStorage.getItem('custId');
  this.cid =  JSON.stringify(this.custId);
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'customerId': this.cid
      })
    };
    httpOptions.headers =
    httpOptions.headers.set('customerId', this.cid);

    console.log("inside sell" + this.custId);
   this.product = 
       {
        "customerId": this.custId,"productName": this.productName, "productCategoryName": this.product_category , "productModel": this.product_model , "productDescription":this.product_desc,
       "productBoughtYear": this.year, "startingBidPrice": this.min_bid_price , "incrementPrice":this.increment, "approvalStatus": 1, "reportFlag": 0, 
       "productImage":[{"productImage":this.Data[0]},{"productImage":this.Data[1]}
       //,{"productImage":this.Data[1]},{"productImage":this.Data[2]},{"productImage":this.Data[3]},{"productImage":this.Data[4]}
      ]
      };

    
      
    
    console.log("image passed"+this.Data[0]);
   console.log(this.product);
     let obs1 =  this.http.post(this.url1,this.product);
       obs1.subscribe((response)=>{
           console.log("response" + response);
            this.productId = response;
            console.log("product id:" +this.productId);
            this.auction();

           })

           console.log("hey");

console.log("product" + this.productId);




/*
           this.auctionMaster =
           {
           "productId":this.productId,"customerId": this.custId,"startingBidPrice": this.min_bid_price ,"finalBidPrice": this.min_bid_price , "bidIncrement":this.increment,
             "productSoldStatus": 1,"auctionDescription":"First Product", "auctionStartDate":this.startDate, "auctionEndDate":this.endDate 
           };


console.log(this.auctionMaster);
           let obs2 =  this.http.post(this.url2,this.auctionMaster);
           console.log("calling auctionMaster ");
       obs2.subscribe(()=>{
            
           })
  */

           this.router.navigate(["congrats"]);

     }


auction(){
  this.auctionMaster =
  {
  "productId":this.productId,"customerId": this.custId,"startingBidPrice": this.min_bid_price ,"finalBidPrice": this.min_bid_price , "bidIncrement":this.increment,
"productSoldStatus":"1","auctionDescription":"First Product"  //, "auctionStartDate":"this.startDate", "auctionEndDate":"this.endDate" 
  };

     console.log(this.auctionMaster.productSoldStatus);
  console.log(this.auctionMaster);
  let obs2 =  this.http.post(this.url2,this.auctionMaster);
  console.log("calling auctionMaster ");
obs2.subscribe(()=>{
   
  })
}



  ngOnInit() {
  }

}
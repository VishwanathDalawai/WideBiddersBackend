import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  url1=environment.apiBaseUrl + "products";

  url5=environment.apiBaseUrl + "getBidAmount/";

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




  constructor(private http:HttpClient,private activate:ActivatedRoute) { }

  ngOnInit() {
  //  console.log("product image1");
  //  this.email = this.activate.snapshot.paramMap.get('email');
    let obs =  this.http.get(this.url1);
    obs.subscribe((response)=>{
        
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

}

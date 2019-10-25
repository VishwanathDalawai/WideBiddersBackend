import { Component, OnInit } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Router} from '@angular/router';

@Component({
  selector: 'app-sell',
  templateUrl: './sell.component.html',
  styleUrls: ['./sell.component.css']
})
export class SellComponent implements OnInit {
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


  Data=[];
  imageData=[];
a:any;
 
  constructor(private http:HttpClient,private router:Router){
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
    { "productImage":this.Data[0] },
    { "productImage":this.Data[1] },
     { "productImage":this.Data[2] },
    { "productImage":this.Data[3] },
    {  "productImage":this.Data[4] }
    ];
*/
    //[{"productImage":"hey"}]

    this.product = 
       {
       "productName": this.product_name, "productCategoryName": this.product_category , "productModel": this.product_model , "description":this.product_desc,
       "year": this.year, "startingBidPrice": this.min_bid_price , "incrementPrice":this.increment, "productImage":this.ProductImages
      };
      console.log(this.Data[0]);
   

       let obs =  this.http.post("http://192.168.2.35:80/addproduct/",this.product);

       

       obs.subscribe(()=>{
            
           })

           this.router.navigate(["congrats"]);

     }
  ngOnInit() {
  }

}

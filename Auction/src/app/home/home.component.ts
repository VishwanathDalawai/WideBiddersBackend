import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

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
  constructor(private http:HttpClient) { }

  ngOnInit() {
    let obs =  this.http.get("http://localhost/products");
    obs.subscribe((response)=>{
        
         this.data = response;
         
         for (var prop in this.data) {
          console.log("Key:" + prop);
          if(this.data[prop].productImage[0]!=undefined)
          {
          console.log("Value:" + this.data[prop].productImage[0].productImage);
          this.imageData.push('data:image/png;base64,'+this.data[prop].productImage[0].productImage);
          }
      }
       //  this.imageData.push('data:image/png;base64,' +this.data[11].productImage[0].productImage);

     //    this.name =this.data[1].productName
       //  console.log(this.imageData);
       // console.log(this.data[1].productName);
        //console.log(this.data[11].productImage[0]);
        })
  }

}

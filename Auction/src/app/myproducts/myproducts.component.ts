import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-myproducts',
  templateUrl: './myproducts.component.html',
  styleUrls: ['./myproducts.component.css']
})
export class MyproductsComponent implements OnInit {
data:any;
imageData=[];
email:any;
  constructor(private http:HttpClient,private activate:ActivatedRoute) { }

  ngOnInit() {
    this.email = this.activate.snapshot.paramMap.get('email');
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

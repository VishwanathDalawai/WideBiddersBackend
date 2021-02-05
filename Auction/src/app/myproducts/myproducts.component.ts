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

  url1 = environment.apiBaseUrl + "productByCustomerId/";
  url5 = environment.apiBaseUrl + "getBidAmount/";
  url3 = environment.apiBaseUrl + "productUpdate/";
  url6 = environment.apiBaseUrl + "productId/";
  url9 = environment.apiBaseUrl + "deleteProduct/";
  url8 = environment.apiBaseUrl + "getBidDates/";


  details: any;
  data: any;
  custId: any;
  currentBidPrice: any;
  updatedDescription: any;
  updatingProductId: any;
  updatedProduct: any;


  updatedProductName: any;
  updatedProductModel: any;
  updatedProductCategory: any;
  updatedProductInitialPrice: any;
  updatedProductIncrement: any;
  updatedProductYear: any;
  updatedProductCustomerId: any;
  updatedProductId: any;

  time: any;
  productAddedDate: any;
  deadline: any;
  timer: any;
  now: any;
  difference: any;
  seconds: any;
  minutes: any;
  hours: any;
  days: any;
  dateEntered: any;
  empty: any;


  constructor(private http: HttpClient, private activate: ActivatedRoute, private router: Router, private customerService: CustomerService, private toastr: ToastrService) { }

  ngOnInit() {

    this.custId = sessionStorage.getItem('custId');

    let obs = this.http.get(this.url1 + this.custId);
    obs.subscribe((response) => {

      this.data = response;

      if (this.data[0] == null) {
        this.empty = true;

      }


      for (let item of this.data) {

        item.hrs = "";
        item.dys = "";
        item.mins = "";
        item.secs = "";

        let obs6 = this.http.get(this.url5 + item.productId);
        obs6.subscribe((response1) => {
          this.currentBidPrice = response1;
          if (this.currentBidPrice == 0) {
            this.currentBidPrice = item.startingBidPrice;

          }
          else {
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
            this.difference = this.dateEntered.getTime() - this.now.getTime(); //difference between end date time and current date time
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

      } //end of for loop

    }

    )
  }

  update(id: string) {
    this.updatingProductId = id;

  }


  delete(id: string) {
    let obs9 = this.http.delete(this.url9 + id);
    obs9.subscribe((Response) => {
      this.toastr.success('Product deleted successfully..', 'Sucess');
      this.ngOnInit();
    })

  }

  //update the description
  updateProduct() {

    let obs = this.http.get(this.url6 + this.updatingProductId);
    obs.subscribe((response) => {

      this.details = response;

      this.updatedProductId = this.details.productId;
      this.updatedProductName = this.details.productName;
      this.updatedProductModel = this.details.productModel;
      this.updatedProductCategory = this.details.productCategoryName;
      this.updatedProductInitialPrice = this.details.startingBidPrice;
      this.updatedProductIncrement = this.details.incrementPrice;
      this.updatedProductYear = this.details.productBoughtYear;
      this.updatedProductCustomerId = this.details.customer.customerId;


      this.send();

    }
    )
  }


  send() {

    this.updatedProduct =
      {
        "customerId": this.updatedProductCustomerId, "productName": this.updatedProductName, "productCategoryName": this.updatedProductCategory, "productModel": this.updatedProductModel, "productDescription": this.updatedDescription,
        "productBoughtYear": this.updatedProductYear, "startingBidPrice": this.updatedProductInitialPrice, "incrementPrice": this.updatedProductIncrement, "approvalStatus": 1, "reportFlag": 0,
        "productId": this.updatedProductId
      };

    let obs7 = this.http.put(this.url3, this.updatedProduct);
    obs7.subscribe((response) => {

    })

    this.toastr.success('Product Detail updated successfully..', 'Sucess');

  }

}

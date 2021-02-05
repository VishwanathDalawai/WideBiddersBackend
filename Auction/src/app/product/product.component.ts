import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { ToastrService } from 'ngx-toastr';
import { formatDate } from '@angular/common';
import { stringify } from '@angular/compiler/src/util';



@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  url2 = environment.apiBaseUrl + "productId/";

  url1 = environment.apiBaseUrl + "placeBid/";

  url3 = environment.apiBaseUrl + "getBidDetailsByProductId/";

  url4 = environment.apiBaseUrl + "customerDetails/";

  url5 = environment.apiBaseUrl + "getBidAmount/";

  url8 = environment.apiBaseUrl + "getBidDates/";
  url9 = environment.apiBaseUrl + "timerComplete/";

  custId: any;
  productId: any;
  data: any;
  bidDetails: any;
  bidAmount: any;
  currentBidPrice: any;
  history: any;
  customerDetail: any;
  bidderCustId: any;
  startingProductPrice: any;
  nextBidPrice: any;
  incrementPrice: any;
  time: any;
  productEndDate: any;
  deadline: any;
  timer: any;
  now: any;
  difference: any;
  seconds: any;
  minutes: any;
  hours: any;
  days: any;
  dateEntered: any;
  dateTime: any;

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private router: Router,
    private toastr: ToastrService

  ) { }


  getProductDetail() {

  }


  ngOnInit() {
    this.productId = this.route.snapshot.paramMap.get('id');

    let obs = this.http.get(this.url2 + this.productId);
    obs.subscribe((response) => {

      this.data = response;
      this.startingProductPrice = this.data.startingBidPrice;
      this.incrementPrice = this.data.incrementPrice;

      this.bidPrice();

    }
    )

    /*  implemented timer */

    let obs8 = this.http.get(this.url8 + this.productId);
    obs8.subscribe((response) => {
      this.time = response;

      this.productEndDate = this.time.auctionEndDate;
      this.deadline = new Date(this.productEndDate);

      this.timer = setInterval(() => {
        this.timeBetweenDates(this.deadline);
      }, 1000);

    }
    )


    /*Bid history */

    let obs2 = this.http.get(this.url3 + this.productId);
    obs2.subscribe((response) => {
      this.history = response;

      for (let item of this.history) {

        item.hrs = "";
        item.hrs = new Date(item.dateTime);
        item.hrs = formatDate(item.hrs, "dd/MM/yyyy HH:mm:ss", "en-IN", null);
      }

    }
    )

  }


  timeBetweenDates(toDate) {
    this.dateEntered = toDate;

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

    }
  }


  bidPrice() {

    let obs6 = this.http.get(this.url5 + this.productId);
    obs6.subscribe((response) => {

      this.currentBidPrice = response;
      if (this.currentBidPrice == 0) {
        this.currentBidPrice = this.startingProductPrice;
      }

      this.nextBidPrice = this.currentBidPrice + this.incrementPrice;

    }
    )

  }

  placeBid() {

    this.custId = sessionStorage.getItem('custId');


    if (this.custId != null) {

      this.nextBidPrice = this.currentBidPrice + this.incrementPrice;

      if (this.bidAmount >= this.nextBidPrice) {

        this.bidDetails =
          {
            "productId": this.productId, "bidderCustomerId": this.custId,
            "bidAmount": this.bidAmount

          };
        let obs1 = this.http.post(this.url1, this.bidDetails);
        obs1.subscribe((response) => {

          if (response == -1) {
            this.toastr.error('The bid amount has changed..Please reload the page..', 'Error');
          }

          else {
            setTimeout(() => {
              this.router.navigate(["bidplaced"]);
            }, 1000);

          }

        })


      }

      else {
        this.toastr.error('Your bid amount should be greater', 'Error');

      }

    }

    else {
      this.toastr.error('You have to be logged in to place the bid', 'Error');
      this.router.navigate(["login"]);
    }

  }

  refresh() {
    this.ngOnInit();
  }

}



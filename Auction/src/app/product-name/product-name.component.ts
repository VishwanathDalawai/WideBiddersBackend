import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-product-name',
  templateUrl: './product-name.component.html',
  styleUrls: ['./product-name.component.css']
})
export class ProductNameComponent implements OnInit {
  url2 = environment.apiBaseUrl + "productByProductName/";
  url5 = environment.apiBaseUrl + "getBidAmount/";
  url8 = environment.apiBaseUrl + "getBidDates/";
  url9 = environment.apiBaseUrl + "timerComplete/";
  data: any;
  productName: any;
  currentBidPrice: any;

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

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private router: Router
  ) { }

  ngOnInit() {
    this.productName = this.route.snapshot.paramMap.get('name'); //name of the product

    let obs = this.http.get(this.url2 + this.productName);
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
          item.productEndDate = this.time.auctionEndDate; //auction end date 
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

      } //end of for loop

    }

    )

  }

}

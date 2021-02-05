import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-category-details',
  templateUrl: './category-details.component.html',
  styleUrls: ['./category-details.component.css']
})
export class CategoryDetailsComponent implements OnInit {

  url2 = environment.apiBaseUrl + "productByCategory/";
  url5 = environment.apiBaseUrl + "getBidAmount/";
  url8 = environment.apiBaseUrl + "getBidDates/";
  url9 = environment.apiBaseUrl + "timerComplete/";
  data: any;
  categoty: any;
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
    /* for same url navigation */
    this.route.queryParamMap.subscribe((paramMap: ParamMap) => {
      const refresh = paramMap.get('refresh');
      if (refresh) {
        this.fetchData();
      }
    });

  }

  fetchData() {
    this.categoty = this.route.snapshot.paramMap.get('category'); //search by category

    let obs = this.http.get(this.url2 + this.categoty);
    obs.subscribe((response) => {

      this.data = response;

      if (this.data[0] == null) {
        this.empty = true;  //if there is no products  

      }
      /* for countdown timer and highest bid price*/
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

      } // end of for loop

    }

    )

  }

}

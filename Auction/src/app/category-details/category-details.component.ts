import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-category-details',
  templateUrl: './category-details.component.html',
  styleUrls: ['./category-details.component.css']
})
export class CategoryDetailsComponent implements OnInit {

  url2=environment.apiBaseUrl + "category/";
data:any;
categoty:any;

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private router:Router
  ) { }

  ngOnInit() {
    this.categoty = this.route.snapshot.paramMap.get('category');
 
  console.log(this.categoty);

    let obs = this.http.get(this.url2 + this.categoty);
    obs.subscribe((response) => {

      this.data = response;
     
 

    }

    )


}
}

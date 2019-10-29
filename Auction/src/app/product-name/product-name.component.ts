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
  url2=environment.apiBaseUrl + "search/";
  data:any;
  productName:any;
  
  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private router:Router
  ) { }

  ngOnInit() {
    this.productName = this.route.snapshot.paramMap.get('name');
 
 console.log(this.productName);

    let obs = this.http.get(this.url2 + this.productName);
    obs.subscribe((response) => {

      this.data = response;
     
 

    }

    )


}

}

import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CustomerService } from '../customer.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  url1 = environment.apiBaseUrl + "getCustEmail/";
  url2 = environment.apiBaseUrl + "customerUpdate/";
  url3 = environment.apiBaseUrl + "customerId/";


  param: any;
  userName: any;
  email: any;
  product_name: string = "";
  custId: any;
  emailId: string;
  data: any;
  Email: any;
  customerName: any;

  currentPassword: any;
  newPassword: any;
  confirmPassword: any;
  passwordDetails: any;
  oldPassword: any;
  customerDetail: any;

  constructor(private router: Router, private activate: ActivatedRoute, private route: ActivatedRoute, private customerService: CustomerService, private http: HttpClient, private toastr: ToastrService) {
    this.param = this.router.url;

  }

  ngOnInit() {

    this.custId = sessionStorage.getItem('custId');

    if (this.custId != null) { //if the customer is loggedin

      this.emailId = sessionStorage.getItem('emailId');
      this.customerName = sessionStorage.getItem('customerName');
    }

  }

  sell() {

    if (this.custId != null) {
      this.router.navigate(["sell"]);

    }
    else {
      this.toastr.error('You have to be logged in to sell a product', 'Error');
      this.router.navigate(["login"]);
    }
  }
  signup() {
    this.router.navigate(["register"]);
  }
  login() {
    this.router.navigate(["login"]);
  }


  search() {

    if (this.product_name == "") {
      this.toastr.error('Please enter the product name', 'Error');
    }
    else {
      this.router.navigate(['productName', this.product_name]);
    }

  }

  car() {
    this.router.navigate(['categoryDetails', 'car'], {
      queryParams: { refresh: new Date().getTime() }  //navigation to same url
    });
  }
  mobile() {
    this.router.navigate(['categoryDetails', 'mobiles'], {
      queryParams: { refresh: new Date().getTime() }
    });
  }
  furniture() {
    this.router.navigate(['categoryDetails', 'furniture'], {
      queryParams: { refresh: new Date().getTime() }
    });
  }

  fashion() {
    this.router.navigate(['categoryDetails', 'fashion'], {
      queryParams: { refresh: new Date().getTime() }
    });
  }

  bikes() {
    this.router.navigate(['categoryDetails', 'bikes'], {
      queryParams: { refresh: new Date().getTime() }
    });
  }

  books() {
    this.router.navigate(['categoryDetails', 'books'], {
      queryParams: { refresh: new Date().getTime() }
    });
  }

  electronics() {
    this.router.navigate(['categoryDetails', 'electronics'], {
      queryParams: { refresh: new Date().getTime() }
    });
  }
  clear() {
    sessionStorage.clear();
    this.ngOnInit();
  }

  changePassword() {
    this.custId = sessionStorage.getItem('custId');

    let obs4 = this.http.get(this.url3 + this.custId);

    obs4.subscribe((response) => {

      this.customerDetail = response;
      this.oldPassword = this.customerDetail.password;
      if (this.currentPassword == this.oldPassword) {  //if the password entered is correct
        this.proceed();
      }
      else {
        this.toastr.error('Check your current password', 'error');
      }

    })
  }

  proceed() {


    if (this.newPassword == this.confirmPassword) { //checking for password mismatch

      this.passwordDetails =
        {
          "customerId": this.custId, "password": this.newPassword, "customerName": this.customerDetail.customerName, "emailId": this.customerDetail.emailId, "phoneNumber": this.customerDetail.phoneNumber

        }

      let obs2 = this.http.put(this.url2, this.passwordDetails);

      obs2.subscribe(() => {

      })

      this.clear();

      this.router.navigate(["/home"]);

      this.toastr.success('You password is changed successfully...Please login again', 'success', { timeOut: 3000 });
    }
    else {
      this.toastr.error('password mismatch', 'error');
    }
  }
}



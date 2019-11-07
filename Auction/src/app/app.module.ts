import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Injectable } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SellComponent } from './sell/sell.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule, HTTP_INTERCEPTORS, HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { FooterComponent } from './footer/footer.component';
import { CongratsComponent } from './congrats/congrats.component';
import { HeaderComponent } from './header/header.component';
import { CategoryComponent } from './category/category.component';
import { ProductComponent } from './product/product.component';
import { BidPlacedComponent } from './bid-placed/bid-placed.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { UserAddedComponent } from './user-added/user-added.component';
import { MyproductsComponent } from './myproducts/myproducts.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { FaqComponent } from './faq/faq.component';
import { AppService } from './app.service';
import { CategoryDetailsComponent } from './category-details/category-details.component';
import { ProductNameComponent } from './product-name/product-name.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
 
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent,
    SellComponent,
    HomeComponent,
    FooterComponent,
    CongratsComponent,
    HeaderComponent,
    CategoryComponent,
    ProductComponent,
    BidPlacedComponent,
    RegisterComponent,
    LoginComponent,
    UserAddedComponent,
    MyproductsComponent,
    ContactUsComponent,
    FaqComponent,
    CategoryDetailsComponent,
    ProductNameComponent
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot({
      timeOut: 1000
    }) // ToastrModule added
  ],
  providers: [HomeComponent],
  bootstrap: [AppComponent]
})





export class AppModule { }



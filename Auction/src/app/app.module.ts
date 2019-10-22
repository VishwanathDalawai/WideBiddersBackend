import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SellComponent } from './sell/sell.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { FooterComponent } from './footer/footer.component';
import { CongratsComponent } from './congrats/congrats.component';
import { HeaderComponent } from './header/header.component';
import { CategoryComponent } from './category/category.component';
import { ProductComponent } from './product/product.component';
import { BidPlacedComponent } from './bid-placed/bid-placed.component';


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
    BidPlacedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SellComponent } from './sell/sell.component';
import { HomeComponent } from './home/home.component';
import { CongratsComponent } from './congrats/congrats.component';
import { CategoryComponent } from './category/category.component';
import { ProductComponent } from './product/product.component';
import { BidPlacedComponent } from './bid-placed/bid-placed.component';


const routes: Routes = [
  {path:"", component:HomeComponent},
  {path:"home", component:HomeComponent},
  {path:"sell", component:SellComponent},
  {path:"congrats", component:CongratsComponent},
  {path:"category", component:CategoryComponent},
  {path:"product/:id", component:ProductComponent},
  {path:"home/product/:id", component:ProductComponent},
  {path:"bidplaced", component:BidPlacedComponent}
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

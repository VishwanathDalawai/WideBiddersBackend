import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SellComponent } from './sell/sell.component';
import { HomeComponent } from './home/home.component';
import { CongratsComponent } from './congrats/congrats.component';
import { CategoryComponent } from './category/category.component';
import { ProductComponent } from './product/product.component';
import { BidPlacedComponent } from './bid-placed/bid-placed.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { UserAddedComponent } from './user-added/user-added.component';
import { HeaderComponent } from './header/header.component';
import { MyproductsComponent } from './myproducts/myproducts.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { FaqComponent } from './faq/faq.component';
import { CategoryDetailsComponent } from './category-details/category-details.component';
import { ProductNameComponent } from './product-name/product-name.component';




const routes: Routes = [
  {path:"", component:HomeComponent},
  {path:"home", component:HomeComponent},
  {path:"home/:email", component:HomeComponent},
  {path:"sell", component:SellComponent},
  {path:"myproduct", component:MyproductsComponent},
  {path:"congrats", component:CongratsComponent},
  {path:"category", component:CategoryComponent},
  {path:"product/:id", component:ProductComponent},
  {path:"home/product/:id", component:ProductComponent},
  {path:"bidplaced", component:BidPlacedComponent},
  {path:"register", component:RegisterComponent},
  {path:"login", component:LoginComponent},
  {path:"userAdded", component:UserAddedComponent},
  {path:"contact", component:ContactUsComponent},
  {path:"faq", component:FaqComponent},
  {path:"categoryDetails/:category", component:CategoryDetailsComponent},
  {path:"productName/:name", component:ProductNameComponent}
  
  
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{
    onSameUrlNavigation: 'reload'
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }

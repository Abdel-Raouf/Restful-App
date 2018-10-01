import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { AppComponent } from './app.component';
import { ProductListComponent } from './products/product-list.component';
import { ProductEditComponent } from './products/product-edit.component';
import { HttpClientModule } from '@angular/common/http';
import { ProductService } from './products/product.service';
import {RouterModule} from '@angular/router'
import { WelcomeComponent } from './home/welcome.component';


@NgModule({
  // to declare angular component so angular can find selectors
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductEditComponent,
    WelcomeComponent
  ],
  // includes browser module so the application can run correctly in the browser and in general to pulling in any externel modules
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path: 'welcome', component:WelcomeComponent},
      {path: '', redirectTo: 'welcome', pathMatch: 'full'}, //to set a default route webpage
      {path: 'products', component: ProductListComponent},
      {path: 'product-edit', component: ProductEditComponent}
    ])
  ],
  // the providers array is for services
  providers: [ProductService],
  // bootstrap array lists our component as the starter component for our application
  bootstrap: [AppComponent]
})
// export our class so we can import it in any module we want to use it in.
export class AppModule { }

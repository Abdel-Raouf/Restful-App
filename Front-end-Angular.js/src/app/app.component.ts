import { Component } from '@angular/core';
import { ProductService } from './products/product.service'


// component decorator is a function so we write brances () and then we are going to pass an object so we write curly braces {} 
@Component ({
  selector: 'pm-root',
  template:`
    <div>
      <nav class='navbar navbar-default' >
        <div class='container-fluid' >
          <a class='navbar-brand' >{{pageTitle}}</a>
          <ul class='nav navbar-nav' >
              <li><a [routerLink]="['/welcome']" >Home</a></li>
              <li><a [routerLink]="['/products']" >Employees List</a></li>
              <li><a [routerLink]="['/product-edit']" >Add Employee</a></li>
          </ul>
        </div>
      </nav>
      <div class='container' >
        <router-outlet></router-outlet>
      </div>
    </div>
  `
})

export class AppComponent {
  // pageTitle: string = "employee management system"
}
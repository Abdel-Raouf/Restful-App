import { Component, OnInit } from "@angular/core";
import { NgForm } from "@angular/forms";
import { IProduct } from './product';
import { ProductService } from './product.service';


// decorator
@Component ({
    selector: 'pm-products',
    templateUrl: './product-list.component.html',
    // encapsulating style related tot he component
    styleUrls: ['./product-list.component.css']
})

// component with it's properties and method
// implements lifecycle hook interface OnInit on the component
export class ProductListComponent implements OnInit{
    [x: string]: any;
    pageTitle: string='Employees List';
    errorMessage: string;



    // we now can perform all our data-binding in this property.
    products: IProduct[] = [];


    constructor(private _productService: ProductService) {

    }

    submitForm(form: NgForm) {
        // console.log(form.value); 

        this._productService.postProducts(this.product)
        .subscribe(data => console.log('success: ', data),
        error => this.errorMessage = <any>error        
        );
    }


    // we cust the error returned to any data type.
    // ngOnInit() fires when the server starts, so we use the get-method inside it.
    // component lifecycle hook to tap into the lifecycle point that is after the component created shortly
    ngOnInit(): void {
        this._productService.getProducts()
        .subscribe(products => {
            this.products = products;
        },
            error => this.errorMessage = <any>error,
        );
        
    }   
}
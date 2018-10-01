import { Component } from '@angular/core';
import { FormGroup, FormControl, FormControlName } from '@angular/forms';
import { ActivatedRoute, Router  } from '@angular/router';

import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/observable/fromEvent';
import 'rxjs/add/observable/merge';
import { Observable } from 'rxjs/Observable';
import { Subscription } from 'rxjs/Subscription';
import { NgForm } from "@angular/forms";


import { IProduct } from './product';
import { ProductService } from './product.service';

@Component({
    templateUrl: './product-edit.component.html'
})

export class ProductEditComponent {

    pageTitle: string = 'Product Edit';
    errorMessage: string;
    productForm: FormGroup;

    product: IProduct = new  IProduct();
    private sub: Subscription;


    constructor(private route: ActivatedRoute,
                private router: Router,
                private productService: ProductService) {

    }



    onProductRetrieved(product: IProduct): void {
        if (this.productForm) {
            this.productForm.reset();
        }
        this.product = product;

        if (this.product.id === 0) {
            this.pageTitle = 'Add Product';
        } 

        // Update the data on the form
        this.productForm.patchValue({
            address: this.product.address,
            id: this.product.id,
            name: this.product.name,
            salary: this.product.salary
        });
        
    }

    submitForm(form: NgForm) {
            // Copy the form values over the product object values
            // let p = Object.assign({}, this.product, this.productForm.value);

            this.productService.postProducts(this.product)
                .subscribe(
                    () => this.onSaveComplete(),
                    (error: any) => this.errorMessage = <any>error
                );
        
    }

    onSaveComplete(): void {
        // Reset the form to clear the flags
        // this.productForm.reset();
        this.router.navigate(['products']);
    }
}

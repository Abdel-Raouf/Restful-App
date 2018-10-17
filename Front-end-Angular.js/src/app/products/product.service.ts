import { Injectable } from "@angular/core";
import { HttpClient, HttpResponse, HttpErrorResponse, HttpHeaders, HttpParams } from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import "rxjs/add/observable/throw";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/do";

import { IProduct } from './product';


@Injectable()
export class ProductService {
    // this defines where we will send our http request
    private _productUrl = "http://localhost:8080/EJBRestfulWebService0/webresources/CounterServiceRest/getAllCustomer";
    private _productPost = "http://localhost:8080/EJBRestfulWebService0/webresources/CounterServiceRest/insertCustomer";
    // using contructor to inject a webservice
    constructor(private _http: HttpClient) {} ;

    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type':  'application/x-www-form-urlencoded'
        })
    }
    // to retrive items form the webservice. 
    getProducts(): Observable<IProduct[]> {
        // get method generic(accept any data type sepcified in the interface) parameter, since we expecting an array of product object we set the generic to an array
        // get method then automatically maps the respose object returned from the backend server to the defined type.
        return this._http.get<IProduct[]>(this._productUrl)
        .do(data => console.log('All: ' + JSON.stringify(data)))
        .catch(this.handleError) ;
        
    }

    postProducts( product: IProduct): Observable<IProduct> {

        let options = {
            headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
        };

        const body = new HttpParams()
            .set('address', product.address)
            .set('id', product.id+"")
            .set('name', product.name)
            .set('salary', product.salary+"");

        return this._http.post<IProduct>(this._productPost, body,options)
        .do(data => console.log('postedData: ' + JSON.stringify(data)))
        .catch(this.handleError) ;
    }

    private handleError(err: HttpErrorResponse) {
        console.log(err.message);
        return Observable.throw(err.message);
    }
}
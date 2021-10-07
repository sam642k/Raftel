import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProductModel } from '../models/product-model';

@Injectable({
  providedIn: 'root'
})
export class CatalogService {

  constructor(private http: HttpClient) { }

  getAllProducts(){
    return this.http.get<ProductModel[]>("http://localhost:8050/catalog");
  }

  getProduct(id: number){
    return this.http.get<ProductModel>(`http://localhost:8050/catalog/${id}`);
  }

  addProduct(product: ProductModel){
    return this.http.post<ProductModel>(`http://localhost:8050/catalog`, product);
  }

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ItemModel } from '../models/item-model';
import { OrderModel } from '../models/order-model';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  checkOut(order: OrderModel){
    return this.http.post<OrderModel>(`http://localhost:8050/order`, order);
  }

  getOrder(userId: number){
    return this.http.get<OrderModel>(`http://localhost:8050/order/${userId}`);
  }

  getItems(userId: number){
    return this.http.get<ItemModel[]>(`http://localhost:8050/order/items/${userId}`);
  }

}

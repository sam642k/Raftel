import { Component, OnInit } from '@angular/core';
import { OrderService } from '../services/order.service';

@Component({
  selector: 'app-all-orders',
  templateUrl: './all-orders.component.html',
  styleUrls: ['./all-orders.component.css']
})
export class AllOrdersComponent implements OnInit {
  
  public userId= -1;
  public name='';
  public orders: any;
  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
    this.userId= parseInt(sessionStorage.getItem('userId') || '-1');
    this.name= sessionStorage.getItem('name') || '';
    this.orderService.getAllOrders(this.userId).subscribe(data=> this.orders=data);
  }

}

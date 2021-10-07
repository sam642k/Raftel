import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { CartService } from '../services/cart.service';
import { OrderService } from '../services/order.service';



@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  public userId=-1;
  public order: any;
  public items: any;
  public name='';
  constructor(public cartService: CartService, public orderService: OrderService, public route: ActivatedRoute) { }

  ngOnInit(): void {
    this.userId= parseInt(sessionStorage.getItem('userId') || '-1');
    this.name= sessionStorage.getItem('name') || '';
    console.log(this.userId);

    this.orderService.getOrder(this.userId).subscribe(data=>{
      this.order=data;
      console.log(this.order);
    });

    this.orderService.getItems(this.userId).subscribe(data=>{
      this.items=data;
      console.log(this.items);
    });
  }

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { CartService } from '../services/cart.service';
import { CatalogService } from '../services/catalog.service';


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  public id: any;
  public product: any;
  public isLoggedIn= false;
  public name='';

  constructor(private authService: AuthService,private catalogService: CatalogService, private cartService: CartService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => this.id= parseInt(params.get('id') || '-1'));
    this.catalogService.getProduct(this.id).subscribe(product => {
      this.product=product
    });
    this.isLoggedIn= this.authService.isLoggedIn();
    this.name=sessionStorage.getItem('name') || '';
    
  }

  addToCart(){
    this.cartService.addToCart(1, this.product.id).subscribe();
  }

}

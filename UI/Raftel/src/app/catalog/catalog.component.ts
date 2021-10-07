import { Component, OnInit } from '@angular/core';
import { ProductModel } from '../models/product-model';
import { AuthService } from '../services/auth.service';
import { CatalogService } from '../services/catalog.service';


@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {
  isLoggedIn= false;
  public name='';
  public products: ProductModel[]=[];
  constructor(private catalogService: CatalogService, private authService: AuthService) { }

  ngOnInit(): void {
    this.catalogService.getAllProducts().subscribe(data =>{
      this.products=data
      console.log(this.products)
    });
    this.isLoggedIn= this.authService.isLoggedIn();
    this.name=sessionStorage.getItem('name') || '';
    
  }

}
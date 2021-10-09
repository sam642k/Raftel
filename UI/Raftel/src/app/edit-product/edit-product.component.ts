import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { CatalogService } from '../services/catalog.service';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {

  name='';
  categories=["Electronics", "Clothing", "Sports"];
  product: any;
  prodId=-1;

  productForm: any;

  constructor(public fb: FormBuilder, public catalogService: CatalogService, public router: Router, public route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap)=> this.prodId= parseInt(params.get('id')||'-1'));
    this.name= sessionStorage.getItem('name') || '';
    this.catalogService.getProduct(this.prodId).subscribe(data=>{
      this.productForm= this.fb.group({
        name: [data.name, [Validators.required, Validators.minLength(3)]],
        category: [data.category, [Validators.required]],
        price: [data.price, [Validators.required]],
        imagesource: [data.image, [Validators.required]],
        image: [''],
        description: ['']
      });
    });
  }

  editProduct(){

  }

  onFileUpload(event: any){
    const reader = new FileReader();
    
    if(event.target.files && event.target.files.length) {
      const [file] = event.target.files;
      reader.readAsDataURL(file);
    
      reader.onload = () => {
     
        this.productForm.patchValue({
          image: reader.result
        });
   
      };
   
    }
  }

}

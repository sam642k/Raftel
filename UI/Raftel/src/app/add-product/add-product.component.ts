import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CatalogService } from '../services/catalog.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  name='';
  categories=["Electronics", "Clothing", "Sports"];

  productForm= this.fb.group({
    name: ['', [Validators.required, Validators.minLength(3)]],
    category: ['', [Validators.required]],
    price: ['', [Validators.required]],
    imagesource: ['', [Validators.required]],
    image: [''],
    description: ['']
  });

  constructor(public fb: FormBuilder, public catalogService: CatalogService, public router: Router) { }

  ngOnInit(): void {
    this.name= sessionStorage.getItem('name') || '';
  }

  addNewProduct(){
    let {imagesource, ...product}= this.productForm.value;
    console.log(product);
    
    this.catalogService.addProduct(product).subscribe();
    this.router.navigate(['']);
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

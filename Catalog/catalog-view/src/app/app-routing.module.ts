import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogListComponent } from './catalog-list/catalog-list.component';

const routes: Routes = [
  {path:'', component: CatalogListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponents=[CatalogListComponent];
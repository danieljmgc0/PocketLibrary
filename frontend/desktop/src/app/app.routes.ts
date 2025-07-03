import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AddBookComponent } from './add-book/add-book.component';
import { App } from './app';

export const routes: Routes = [
  { path: "/menu", component: App} ,
  { path: 'add-book', component: AddBookComponent },
  { path: '/', redirectTo: '/menu', pathMatch: 'full' },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })

  export class AppRoutingModule { }

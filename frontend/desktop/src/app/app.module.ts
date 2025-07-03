// src/app/app.module.ts
import { NgModule }              from '@angular/core';
import { BrowserModule }         from '@angular/platform-browser';
import { RouterModule, Routes }  from '@angular/router';

import { App }          from './app';
import { AddBookComponent }      from './add-book/add-book.component'; // standalone

const routes: Routes = [
  { path: 'add-book',     component: AddBookComponent },
  { path: '', redirectTo: '/add-book', pathMatch: 'full' },
  // ...otras rutas
];

@NgModule({
  declarations: [
    App              // Solo declara aquí componentes NO-standalone
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes), // <-- importa el RouterModule con tus rutas
    AddBookComponent             // <-- IMPORTA el componente standalone, NO lo declares
  ],
  bootstrap: [App]
})
export class AppModule { }

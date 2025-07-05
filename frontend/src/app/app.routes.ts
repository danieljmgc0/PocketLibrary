
import { AddBook } from './add-book/add-book';
import { NgModule } from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

export const routes: Routes = [
    {path: 'books', component: AddBook},
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule {}

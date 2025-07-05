import { CommonModule } from '@angular/common';
import { HttpClient, HttpErrorResponse, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule }  from '@angular/forms';
import { Book } from '../shared/model';
import { ClienteApiRestService } from '../shared/api.service';



@Component({
  selector: 'app-add-book',
  imports: [
    CommonModule,                            // <-- para *ngIf, *ngFor...
    FormsModule,                             // <-- para ngForm, ngModel
    HttpClientModule                         // <-- para HttpClient
  ],
  templateUrl: './add-book.html',
  styleUrls: ['./add-book.css']              // <-- corregido a styleUrls
})


export class AddBook {
  book: Book = { isbn: '', title: '' };
  public message: string = '';

  // Ajusta la URL a la de tu API
  constructor(private http: HttpClient, private clienteApiRestService: ClienteApiRestService) {}

  submitBook(): void {
    //console.log('Enviando libro:', this.book);
    this.clienteApiRestService.addBook(this.book).subscribe({
      next: resp => {
        if (resp.status < 400) {
          this.message = 'Libro creado correctamente';
          this.book = { isbn: '', title: '' }; // Limpiar el formulario
        }
      },
      error: err => {
        console.log("Error al crear: " + err.message);
        throw err;
      }
    });
  }
}

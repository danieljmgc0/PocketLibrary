import { Component, OnInit } from '@angular/core';
//import { Hotel, RoomType, Room, Booking, User, UserStatus, Booking2 } from '../shared/app.model';
import { ApiRestService } from '../shared/api-rest.service';
//import { DataService } from '../shared/data.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, FormsModule } from '@angular/forms';

import { DTOBook } from '../shared/app.model';
import { CommonModule } from '@angular/common';






@Component({
    selector: 'add-book',
    templateUrl: './add-book.component.html',
    styleUrl: './add-book.component.css',
    imports: [ CommonModule, FormsModule ],
})


export class AddBookComponent implements OnInit {
  bookVacio = {
    isbn:'',
    title: '',
  }

  book = this.bookVacio as unknown as DTOBook
  //hotelesConHabitaciones: { hotel: Hotel; rooms: Room[] }[] = []; // Lista para almacenar hoteles y sus habitaciones
  constructor(private ruta: ActivatedRoute, private router: Router, private clienteApiRest: ApiRestService) { }

  ngOnInit() {
    
  }

  onSubmit() {
    this.clienteApiRest.addBook(this.book.isbn, this.book.title).subscribe(
      resp => {
        if (resp.status < 400) {
          alert('Reserva creada con éxito');
          //this.router.navigate(['/bookings']);
        } else {
          alert('Error al crear la reserva');
        }
      },
      err => {
        alert('Error al crear la reserva: ' + err.message);
      }
    );
  }
  
}
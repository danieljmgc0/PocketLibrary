import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from './model';
@Injectable({ providedIn: 'root' })


export class ClienteApiRestService {
  static addBook(book: any) {
    throw new Error('Method not implemented.');
  }
  private static readonly BASE_URL = 'http://localhost:8080';
  private static readonly BOOKS_URL = ClienteApiRestService.BASE_URL + '/books';
  constructor(private http: HttpClient) { }

addBook(book: Book): Observable<HttpResponse<any>> {
    let url = `${ClienteApiRestService.BOOKS_URL}/create`;
    console.log('Enviando libro api:', book);
    return this.http.post(url, book, { observe: 'response', responseType: 'text' });
  }
}
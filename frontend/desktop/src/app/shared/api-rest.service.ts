import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
//import { Booking, Booking2, Hotel, Room, User, LoginRequest, RegisterRequest } from './app.model';
import { Observable } from 'rxjs';
@Injectable({ providedIn: 'root' })
export class ApiRestService {
  private static readonly BASE_URI = 'http://localhost:8080/';
    private static readonly BOOKS_URI = ApiRestService.BASE_URI + 'books';
    constructor(private http: HttpClient) { }

    addBook(isbn: string, title: string): Observable<HttpResponse<any>> {
        let url = `${ApiRestService.BOOKS_URI}/${isbn}/${title}`;
        return this.http.post(url, {}, { observe: 'response', responseType: 'text' });
    }
}
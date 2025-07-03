import { Component, NgModule } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ApiRestService } from './shared/api-rest.service';
import { AddBookComponent } from './add-book/add-book.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app.routes';



@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrl: './app.css',
  standalone: false
})


@Component({
  selector: 'app-root',
  templateUrl: './app.html'
})
export class App { }
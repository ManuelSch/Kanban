import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './components/app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BoardComponent } from './components/board/board.component';
import { HomeComponent } from './components/home/home.component';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { HttpClientModule } from '@angular/common/http';
import { ApiService } from './services/api.service';
import { BoardService } from './services/board.service';
import { BoardColumnComponent } from './components/board/board-column/board-column.component';

@NgModule({
  declarations: [
    AppComponent,
    BoardComponent,
    HomeComponent,
    BoardColumnComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatIconModule,
    MatButtonModule,
  ],
  providers: [
    ApiService,
    BoardService,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {
}

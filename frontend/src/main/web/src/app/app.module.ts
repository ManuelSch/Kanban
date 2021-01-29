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
import { MatCardModule } from '@angular/material/card';
import { TaskComponent } from './components/board/board-column/task/task.component';
import { MatRippleModule } from '@angular/material/core';
import { DragDropModule } from '@angular/cdk/drag-drop';

@NgModule({
  declarations: [
    AppComponent,
    BoardComponent,
    HomeComponent,
    BoardColumnComponent,
    TaskComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatRippleModule,
    DragDropModule,
  ],
  providers: [
    ApiService,
    BoardService,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {
}

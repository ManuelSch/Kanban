import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Location } from '@angular/common';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {

  allBoards: unknown;

  constructor(private http: HttpClient, private location: Location) {
  }

  ngOnInit(): void {
    this.getAllBoards();
  }

  public createNewBoard() {
    const body = {
      title: 'My first Angular board',
    };
    const url = window.location.protocol + '//' + window.location.hostname + ':8080/api/board';
    this.http.post(url, body).subscribe(res => {
      console.log(res);
    });
    this.getAllBoards();
  }

  public getAllBoards() {
    const url = window.location.protocol + '//' + window.location.hostname + ':8080/api/board/all';
    this.http.get(url).subscribe(res => this.allBoards = res);
  }
}

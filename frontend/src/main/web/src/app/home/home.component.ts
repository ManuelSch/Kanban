import { Component, OnInit } from '@angular/core';
import { BoardService } from '../services/board.service';
import { Board } from '../models/Board';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {

  allBoards: Board[] = [];

  constructor(private boardService: BoardService) {
  }

  ngOnInit() {
    this.getAllBoards();
  }

  public async createNewBoard() {
    await this.boardService.createBoard('My first Angular board');
    await this.getAllBoards();
  }

  public async getAllBoards() {
    this.allBoards = await this.boardService.getAllBoards();
  }
}

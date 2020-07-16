import { Component, OnInit } from '@angular/core';
import { BoardService } from '../../services/board.service';
import { Board } from '../../models/Board';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {

  allBoards: Board[] = [];

  constructor(private boardService: BoardService, private router: Router) {
  }

  ngOnInit() {
    this.getAllBoards();
  }

  public async createNewBoard() {
    const createdBoard = await this.boardService.createBoard('My first Angular board');
    this.router.navigateByUrl(`/${createdBoard.id}`);
  }

  public async getAllBoards() {
    this.allBoards = await this.boardService.getAllBoards();
  }
}

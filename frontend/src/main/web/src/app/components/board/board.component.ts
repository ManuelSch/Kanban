import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BoardService } from '../../services/board.service';
import { Board } from '../../models/Board';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.scss'],
})
export class BoardComponent implements OnInit {

  board?: Board;

  constructor(private route: ActivatedRoute, private boardService: BoardService) {
  }

  async ngOnInit() {
    this.board = await this.boardService.getBoardById(this.route.snapshot.params['boardId']);
  }

}

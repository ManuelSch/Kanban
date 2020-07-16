import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BoardService } from '../../services/board.service';
import { Board } from '../../models/Board';
import { BoardColumnService } from '../../services/board-column.service';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.scss'],
})
export class BoardComponent implements OnInit {

  board?: Board;

  constructor(private route: ActivatedRoute, private router: Router, private boardService: BoardService, private boardColumnService: BoardColumnService) {
  }

  async ngOnInit() {
    try {
      this.board = await this.boardService.getBoardById(this.route.snapshot.params['boardId']);
      this.board.columns = this.board.columns.sort((a, b) => a.position - b.position);
    }
    catch (e) {
      await this.router.navigateByUrl('/');
    }
  }

  async createNewColumn() {
    this.board = await this.boardColumnService.createBoardColumn('New Kanban column', this.board.id);
  }

}

import { Component, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BoardService } from '../../services/board.service';
import { Board } from '../../models/Board';
import { BoardColumnService } from '../../services/board-column.service';
import { MatRipple } from '@angular/material/core';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.scss'],
})
export class BoardComponent {

  @ViewChild('boardTitle', { read: MatRipple })
  boardTitle: MatRipple;

  board?: Board;

  get sortedColumns() {
    return ((this.board || {}).columns || []).sort((a, b) => a.position - b.position);
  }

  constructor(private route: ActivatedRoute, private router: Router, private boardService: BoardService, private boardColumnService: BoardColumnService) {
  }

  async ngAfterViewInit() {
    this.boardTitle.disabled = true;

    try {
      this.board = await this.boardService.getBoardById(this.route.snapshot.params['boardId']);
    }
    catch (e) {
      await this.router.navigateByUrl('/');
    }
  }

  async createNewColumn() {
    this.board = await this.boardColumnService.createBoardColumn('New Kanban column', this.board.id);
  }

  async editBoardTitle() {
    const newTitle = prompt('Board name', this.board.title);
    if (newTitle && newTitle !== this.board.title) {
      this.board = await this.boardService.updateBoard(this.board.id, newTitle);
      this.boardTitle.launch({});
    }
  }

}

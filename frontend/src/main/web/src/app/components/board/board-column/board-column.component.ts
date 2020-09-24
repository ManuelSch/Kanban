import { Component, Input, OnInit } from '@angular/core';
import { BoardColumn } from '../../../models/BoardColumn';
import { BoardColumnService } from '../../../services/board-column.service';

@Component({
  selector: 'app-board-column',
  templateUrl: './board-column.component.html',
  styleUrls: ['./board-column.component.scss'],
})
export class BoardColumnComponent implements OnInit {

  @Input()
  column: BoardColumn;

  constructor(private boardColumnService: BoardColumnService) {
  }

  ngOnInit(): void {
  }

  async editColumnTitle() {
    const title = prompt('Column name', this.column.title);
    if (title && title !== this.column.title) {
      this.column = await this.boardColumnService.updateBoardColumn(this.column.id, { title });
    }
  }
}
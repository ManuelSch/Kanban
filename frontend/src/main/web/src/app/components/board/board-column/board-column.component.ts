import { Component, Input, OnInit } from '@angular/core';
import { BoardColumn } from '../../../models/BoardColumn';
import { BoardColumnService } from '../../../services/board-column.service';
import { TaskService } from '../../../services/task.service';

@Component({
  selector: 'app-board-column',
  templateUrl: './board-column.component.html',
  styleUrls: ['./board-column.component.scss'],
})
export class BoardColumnComponent implements OnInit {

  @Input()
  column: BoardColumn;

  constructor(private boardColumnService: BoardColumnService, private taskService: TaskService) {
  }

  ngOnInit(): void {
  }

  async editColumnTitle() {
    const title = prompt('Column name', this.column.title);
    if (title && title !== this.column.title) {
      Object.assign(this.column, await this.boardColumnService.updateBoardColumn(this.column.id, { title }));
    }
  }

  async createNewTask() {
    this.column.tasks.push(await this.taskService.createTask(this.column.id, 'New Task'));
  }
}

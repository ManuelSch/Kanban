import { Component, Input, OnInit } from '@angular/core';
import { BoardColumn } from '../../../models/BoardColumn';
import { BoardColumnService } from '../../../services/board-column.service';
import { TaskService } from '../../../services/task.service';
import { moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { Task } from 'src/app/models/Task';

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

  sortedTasks() {
    return this.column?.tasks?.sort((a, b) => a.position - b.position);
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

  async drop({ item, previousContainer, previousIndex, container, currentIndex }, columnId) {
    if (previousContainer === container) {
      moveItemInArray(container.data, previousIndex, currentIndex);

      (previousContainer.data as Task[]).forEach(async (task, index) => {
        if (task.position != index) {
          Object.assign(task, await this.taskService.updateTask(task.id, { position: index }));
        }
      });
    }
    else {
      transferArrayItem(previousContainer.data,
        container.data,
        previousIndex,
        currentIndex,
      );

      (previousContainer.data as Task[]).forEach(async (task, index) => {
        if (task.position != index) {
          Object.assign(task, await this.taskService.updateTask(task.id, { position: index }));
        }
      });

      (container.data as Task[]).forEach(async (task, index) => {
        const updatedData: any = {};

        if (task.position != index) {
          updatedData.position = index;
        }

        if (task.id === item.data.id) {
          updatedData.boardColumnId = columnId;
        }

        if (updatedData.position || updatedData.boardColumnId) {
          Object.assign(task, await this.taskService.updateTask(task.id, updatedData));
        }
      });
    }


  }
}

import { Component, Input, OnInit } from '@angular/core';
import { Task } from 'src/app/models/Task';
import { TaskService } from '../../../../services/task.service';
import { Priority } from '../../../../models/Priority';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.scss'],
})
export class TaskComponent implements OnInit {

  @Input()
  task: Task;

  constructor(private taskService: TaskService) {
  }

  get priorityIcon() {
    switch (this.task.priority) {
      case 'HIGH':
        return '⚠';
      case 'MEDIUM':
        return '〰';
      case 'LOW':
        return '💤';
    }
  }

  ngOnInit(): void {
  }

  async editTaskTitle() {
    const title = prompt('Task name', this.task.title);
    if (title && title !== this.task.title) {
      Object.assign(this.task, await this.taskService.updateTask(this.task.id, { title }));
    }
  }

  async selectTaskColor() {
    const color = prompt('Color', this.task.color);
    if (color && color !== this.task.color) {
      Object.assign(this.task, await this.taskService.updateTask(this.task.id, { color }));
    }
  }

  async editTaskDescription() {
    const description = prompt('Description', this.task.description);
    if (description && description !== this.task.description) {
      Object.assign(this.task, await this.taskService.updateTask(this.task.id, { description }));
    }
  }

  async toggleTaskPriority() {
    let priority: Priority;
    switch (this.task.priority) {
      case 'HIGH':
        priority = 'LOW';
        break;
      case 'MEDIUM':
        priority = 'HIGH';
        break;
      case 'LOW':
        priority = 'MEDIUM';
        break;
    }
    if (priority && priority !== this.task.priority) {
      Object.assign(this.task, await this.taskService.updateTask(this.task.id, { priority }));
    }
  }
}

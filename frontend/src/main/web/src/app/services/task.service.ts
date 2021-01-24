import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Task } from '../models/Task';
import { Priority } from '../models/Priority';

@Injectable({
  providedIn: 'root',
})
export class TaskService {

  constructor(private apiService: ApiService) {
  }

  public async createTask(boardColumnId: string, title: string): Promise<Task> {
    const body = {
      boardColumnId,
      title,
    };
    return this.apiService.post('/task', body);
  }

  public async updateTask(id: string, data: { title?: string, color?: string, priority?: Priority, description?: string }): Promise<Task> {
    const body = {
      id,
      ...data,
    };
    return this.apiService.post('/task/update', body);
  }
}

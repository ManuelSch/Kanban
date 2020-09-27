import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Task } from '../models/Task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private apiService: ApiService) { }

  public async createTask(boardColumnId: string, title: string): Promise<Task> {
    const body = {
      boardColumnId,
      title,
    }
    return this.apiService.post('/task', body);
  }
}

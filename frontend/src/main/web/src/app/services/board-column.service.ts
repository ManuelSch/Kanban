import { Injectable } from '@angular/core';
import { Board } from '../models/Board';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root',
})
export class BoardColumnService {

  constructor(private apiService: ApiService) {
  }

  public async createBoardColumn(title: string, boardId: string): Promise<Board> {
    const body = {
      title,
      boardId,
    };
    return this.apiService.post('/boardColumn', body);
  }

  public async updateBoardColumn(id: string, data: {title?: string, position?: number}): Promise<Board> {
    const body = {
      id,
      ...data,
    };
    return this.apiService.post('/boardColumn/update', body)
  }
}

import { Injectable } from '@angular/core';
import { Board } from '../models/Board';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class BoardService {

  constructor(private apiService: ApiService) { }

  public async createBoard(title: string) {
    const body = {
      title,
    };
    return this.apiService.post<Board[]>('/board', body);
  }

  public async getAllBoards(): Promise<Board[]> {
    return this.apiService.get<Board[]>('/board/all');
  }
}

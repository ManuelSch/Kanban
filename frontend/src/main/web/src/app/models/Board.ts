import { BoardColumn } from './BoardColumn';

export class Board {
  id?: string;
  title: string;
  columns: BoardColumn[] = [];
}

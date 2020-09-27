import { Task } from './Task';

export class BoardColumn {
  id?: string;
  title: string;
  position?: number;
  tasks: Task[];
}

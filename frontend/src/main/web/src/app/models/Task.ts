import { Priority } from './Priority';

export class Task {
  id?: string;
  title: string;
  position: number;
  color?: string;
  priority?: Priority;
  description?: string;
}

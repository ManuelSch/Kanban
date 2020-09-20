import { Component, Input, OnInit } from '@angular/core';
import { BoardColumn } from '../../../models/BoardColumn';

@Component({
  selector: 'app-board-column',
  templateUrl: './board-column.component.html',
  styleUrls: ['./board-column.component.scss']
})
export class BoardColumnComponent implements OnInit {

  @Input()
  column: BoardColumn;

  constructor() { }

  ngOnInit(): void {
  }

}

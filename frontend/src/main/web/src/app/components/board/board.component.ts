import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.scss']
})
export class BoardComponent implements OnInit {

  boardId: Observable<String> = this.route.paramMap.pipe(
    map(params => params.get('boardId'))
  );

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

}

import { TestBed } from '@angular/core/testing';

import { BoardColumnService } from './board-column.service';

describe('BoardColumnService', () => {
  let service: BoardColumnService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BoardColumnService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { SearchIdService } from './search-id.service';

describe('SearchIdService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SearchIdService = TestBed.get(SearchIdService);
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { DealTypesService } from './deal-types.service';

describe('DealTypesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DealTypesService = TestBed.get(DealTypesService);
    expect(service).toBeTruthy();
  });
});

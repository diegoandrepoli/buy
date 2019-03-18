import { TestBed } from '@angular/core/testing';

import { BuyOptionService } from './buy-option.service';

describe('BuyOptionService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BuyOptionService = TestBed.get(BuyOptionService);
    expect(service).toBeTruthy();
  });
});

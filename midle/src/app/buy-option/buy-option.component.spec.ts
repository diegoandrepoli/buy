import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BuyOptionComponent } from './buy-option.component';

describe('BuyOptionComponent', () => {
  let component: BuyOptionComponent;
  let fixture: ComponentFixture<BuyOptionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BuyOptionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BuyOptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

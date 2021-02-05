import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BidPlacedComponent } from './bid-placed.component';

describe('BidPlacedComponent', () => {
  let component: BidPlacedComponent;
  let fixture: ComponentFixture<BidPlacedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BidPlacedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BidPlacedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

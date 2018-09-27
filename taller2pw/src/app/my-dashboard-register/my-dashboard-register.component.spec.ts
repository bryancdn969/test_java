
import { fakeAsync, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyDashboardRegisterComponent } from './my-dashboard-register.component';

describe('MyDashboardRegisterComponent', () => {
  let component: MyDashboardRegisterComponent;
  let fixture: ComponentFixture<MyDashboardRegisterComponent>;

  beforeEach(fakeAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ MyDashboardRegisterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MyDashboardRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should compile', () => {
    expect(component).toBeTruthy();
  });
});

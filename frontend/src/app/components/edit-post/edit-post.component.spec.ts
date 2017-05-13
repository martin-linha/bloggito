/* tslint:disable:no-unused-variable */
import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {EditPostComponent} from "./edit-post.component";

describe('PostsComponent', () => {
  let component: EditPostComponent;
  let fixture: ComponentFixture<EditPostComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [EditPostComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

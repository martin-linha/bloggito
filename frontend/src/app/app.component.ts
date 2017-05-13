import { Component } from '@angular/core';
import { OnInit, ViewEncapsulation } from '@angular/core';
import 'rxjs/add/operator/toPromise';

import 'rxjs/add/operator/toPromise';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor() {}

  ngOnInit(): void {
  }
}

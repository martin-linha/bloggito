import { Component } from '@angular/core';
import { OnInit, ViewEncapsulation } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import 'rxjs/add/operator/toPromise';
import {Certification} from "./model/certification";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  certifications: Certification[];

  constructor(private http:Http) {}

  ngOnInit(): void {
    this.getCertifications();
  }

  getCertifications() {
    return this.http.get('http://localhost:8080/api/certifications')
      .toPromise()
      .then(resp => this.certifications = resp.json())
      .catch(err => console.log(err));
  }
}

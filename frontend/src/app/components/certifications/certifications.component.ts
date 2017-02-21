import { Component, OnInit, Input } from '@angular/core';
import {Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';
import {Certification} from "../../model/certification";

@Component({
  selector: 'app-certifications',
  templateUrl: './certifications.component.html',
  styleUrls: ['./certifications.component.css']
})
export class CertificationsComponent implements OnInit {

  @Input() certifications: Certification[];

  constructor(private http: Http) { }

  ngOnInit() {
  }
}

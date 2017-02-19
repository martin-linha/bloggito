import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import {Certification} from "../certifications/certification";
import {Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';

@Component({
  selector: 'app-add-certification',
  templateUrl: './add-certification.component.html',
  styleUrls: ['./add-certification.component.css']
})
export class AddCertificationComponent implements OnInit {

  certification: Certification = new Certification();
  @Output() certificationAdded: EventEmitter<any> = new EventEmitter();

  constructor(private http: Http) { }

  ngOnInit() {
  }

  save() {
    this.http.post('http://localhost:8080/api/certifications', this.certification)
      .toPromise()
      .then(resp => {
        console.log(resp.statusText);
        console.log("emitting...");
        this.certificationAdded.emit();
      });
  }
}

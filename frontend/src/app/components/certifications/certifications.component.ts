import {Component, OnInit, Input} from '@angular/core';
import {Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';
import {Certification} from "../../model/certification";
import {CertificationsService} from "../../services/certifications.service";

@Component({
  selector: 'app-certifications',
  templateUrl: './certifications.component.html',
  styleUrls: ['./certifications.component.css']
})
export class CertificationsComponent implements OnInit {

  certifications: Certification[];

  constructor(private http: Http, private certificationsService: CertificationsService) {
    this.certificationsService.certificationEmmiter.subscribe(certificationAdded => {
      this.getCertifications();
    })
  }

  ngOnInit() {
    this.getCertifications();
  }

  getCertifications() {
    return this.http.get('http://localhost:8080/api/certifications')
      .toPromise()
      .then(resp => this.certifications = resp.json())
      .catch(err => console.log(err));
  }
}

import {Component, OnInit, Output, EventEmitter} from '@angular/core';
import {Certification} from "../../model/certification";
import {Http} from '@angular/http';
import {AuthHttp} from 'angular2-jwt';

import 'rxjs/add/operator/toPromise';
import {CertificationsService} from "../../services/certifications.service";

@Component({
  selector: 'app-add-certification',
  templateUrl: './add-certification.component.html',
  styleUrls: ['./add-certification.component.css']
})
export class AddCertificationComponent implements OnInit {

  certification: Certification = new Certification();

  constructor(private http: Http, private authHttp: AuthHttp, private certificationService: CertificationsService) {
  }

  ngOnInit() {
  }

  save() {
    this.authHttp.post('http://localhost:8080/api/certifications', this.certification)
      .toPromise()
      .then(resp => {
        this.certificationService.certificationEmmiter.emit();
      });
  }
}

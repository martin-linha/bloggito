import {Component, OnInit} from '@angular/core';
import {Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';
import {UserDetail} from "../../model/user-detail";

@Component({
  selector: 'app-contribution-activity',
  templateUrl: './contribution-activity.component.html',
  styleUrls: ['./contribution-activity.component.css']
})
export class ContributionActivityComponent implements OnInit {
  user: UserDetail = new UserDetail();
  email: string = 'martin.linha6@gmail.com';

  constructor(private http: Http) {
  }

  ngOnInit() {
    this.getUserDetail();
  }

  getUserDetail() {
    this.http.get('http://localhost:8080/api/user/' + encodeURI(this.email))
      .toPromise()
      .then(resp => {
        console.log('xxx');
        console.log(resp.json());
        console.log('xxxx');
        this.user = resp.json();
      });
  }
}

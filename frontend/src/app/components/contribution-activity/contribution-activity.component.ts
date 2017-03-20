import {Component, OnInit} from '@angular/core';
import {Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';
import {GithubUser} from "./github-user";

@Component({
  selector: 'app-contribution-activity',
  templateUrl: './contribution-activity.component.html',
  styleUrls: ['./contribution-activity.component.css']
})
export class ContributionActivityComponent implements OnInit {
  stackOverflowUser: any;
  githubUser: GithubUser = new GithubUser();
  email: string = 'martin.linha6@gmail.com';

  constructor(private http: Http) {
  }

  ngOnInit() {
    this.stackOverflowUser = this.getStackoverflowUser();
    this.getGithubAccount();
  }

  getStackoverflowUser() {
    return this.http.get('https://api.stackexchange.com/2.2/users/4460867?order=desc&sort=reputation&site=stackoverflow')
      .toPromise()
      .then(resp => {
        this.stackOverflowUser = resp.json().items[0];
      })
      .catch(err => console.log(err));
  }

  getGithubAccount() {
    this.http.post('http://localhost:8080/api/user/github', this.email)
      .toPromise()
      .then(resp => {
        console.log(resp.statusText);
        this.githubUser = resp.json();
      });
  }
}

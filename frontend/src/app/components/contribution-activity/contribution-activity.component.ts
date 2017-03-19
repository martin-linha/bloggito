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

  constructor(private http: Http) {
  }

  ngOnInit() {
    this.stackOverflowUser = this.getStackoverflowUser();
    this.getGithubCommitCount();
    this.getGithubRepoCount()
  }

  getStackoverflowUser() {
    return this.http.get('https://api.stackexchange.com/2.2/users/4460867?order=desc&sort=reputation&site=stackoverflow')
      .toPromise()
      .then(resp => {
        this.stackOverflowUser = resp.json().items[0];
      })
      .catch(err => console.log(err));
  }

  getGithubRepoCount() {
    return this.http.get('https://api.github.com/users/martin-linha/repos?type=all')
      .toPromise()
      .then(resp => {
        let repos = resp.json();


        this.githubUser.repoCount = resp.json().length;


      })
      .catch(err => console.log(err));
  }

  getGithubCommitCount() {
    return this.http.get('https://api.stackexchange.com/2.2/users/4460867?order=desc&sort=reputation&site=stackoverflow')
      .toPromise()
      .then(resp => {
        this.stackOverflowUser = resp.json().items[0];
      })
      .catch(err => console.log(err));
  }
}

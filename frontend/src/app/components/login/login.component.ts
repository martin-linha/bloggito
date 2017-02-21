import { Component, OnInit } from '@angular/core';
import {UserDetail} from "../../model/user-detail";
import {Http} from '@angular/http';
import {Router} from '@angular/router';


import 'rxjs/add/operator/toPromise';
import {AuthGuardService} from "../../services/auth-guard.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userDetail: UserDetail = new UserDetail();

  constructor(private router: Router, private http: Http, private authGuard: AuthGuardService) { }

  ngOnInit() {
  }

  login() {
    this.http.post('http://localhost:8080/api/user', this.userDetail)
      .toPromise()
      .then(resp => {
        if (resp.status = 200) {
          localStorage.setItem("user", resp.json());
          if (this.authGuard.urlRequested != null) {
            this.router.navigate([this.authGuard.urlRequested])
          } else {
            this.router.navigate([''])
          }

        }
        console.log(resp.json());
      });
  }
}

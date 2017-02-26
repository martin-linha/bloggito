import {Component, OnInit} from '@angular/core';
import {UserDetail} from "../../model/user-detail";
import {Http} from '@angular/http';
import {Router} from '@angular/router';


import 'rxjs/add/operator/toPromise';
import {AuthGuardService} from "../../services/auth-guard.service";
import {AuthService} from "../../services/auth.service";
import {AuthenticationResult} from "../../model/authentication-result";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userDetail: UserDetail = new UserDetail();
  submitted: boolean;
  failedOn403: boolean;

  constructor(private router: Router, private http: Http, private authService: AuthService) {
  }

  ngOnInit() {
  }

  login() {
    this.authService.authenticate(this.userDetail).then(resp => {
        this.submitted = true;
        if (resp.result) {
          let navigateTo = resp.urlRequested != null ? resp.urlRequested : '';
          this.router.navigate([navigateTo]);
        } else {
          this.failedOn403 = true;
        }
      }
    );
  }
}

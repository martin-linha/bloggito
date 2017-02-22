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

  constructor(private router: Router, private http: Http, private authService: AuthService) {
  }

  ngOnInit() {
  }

  login() {
    // this.authService.authenticate(this.userDetail).then(resp => {
    //   resp.
    //   AuthenticationResult result = <AuthenticationResult> resp;
    //   console.log(result.result);
    // })
  }
}

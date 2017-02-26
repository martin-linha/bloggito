import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';


import 'rxjs/add/operator/toPromise';
import {UserDetail} from "../model/user-detail";
import {AuthenticationResult} from "../model/authentication-result";

@Injectable()
export class AuthService {

  urlRequested: string;

  constructor(private http: Http) {
  }

  isAuthenticated(): boolean {
    console.log(localStorage.getItem("user"));
    return localStorage.getItem("user") != null;
  }

  authenticate(userDetail: UserDetail): PromiseLike<AuthenticationResult> {
    return this.http.post('http://localhost:8080/api/user', userDetail)
      .toPromise().then(resp => {
        if (resp.status == 200) {
          localStorage.setItem("user", resp.json());
          return new AuthenticationResult(true, this.urlRequested, resp);
        }
      }).catch(error => {
        return new AuthenticationResult(false, this.urlRequested, error);
      })
  }
}

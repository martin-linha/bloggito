import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {CanActivate, ActivatedRouteSnapshot,
  RouterStateSnapshot} from '@angular/router';

@Injectable()
export class AuthGuardService implements CanActivate {

  urlRequested: string;

  constructor(private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (localStorage.getItem("user") == null) {
      this.urlRequested = state.url;
      this.router.navigate(['/login']);
    }
    return true;
  }
}

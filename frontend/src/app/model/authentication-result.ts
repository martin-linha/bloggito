import {UserDetail} from "./user-detail";

export class AuthenticationResult {

  constructor(private result: boolean, private urlRequested: string, private userDetail: UserDetail, private httpResponse: any) {
    this.result = result;
    this.urlRequested = urlRequested;
    this.userDetail = userDetail;
    this.httpResponse = httpResponse;
  }
}

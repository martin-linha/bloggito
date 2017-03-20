export class UserDetail {
  email: string;
  password: string;
  githubAccount: GithubAccount = new GithubAccount();
}

export class GithubAccount {
  private _repoCount: number;
  private _commitCount: number;
  private _githubId: string;


  get repoCount(): number {
    return this._repoCount;
  }

  set repoCount(value: number) {
    this._repoCount = value;
  }

  get commitCount(): number {
    return this._commitCount;
  }

  set commitCount(value: number) {
    this._commitCount = value;
  }

  get githubId(): string {
    return this._githubId;
  }

  set githubId(value: string) {
    this._githubId = value;
  }
}

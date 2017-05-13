export class UserDetail {
  email: string;
  password: string;
  githubAccount: GithubAccount = new GithubAccount();
  stackOverflowAccount: StackOverflowAccount = new StackOverflowAccount();
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

export class StackOverflowAccount {
  private _points: number;
  private _bronze: number;
  private _silver: number;
  private _gold: number;

  get points(): number {
    return this._points;
  }

  set points(value: number) {
    this._points = value;
  }

  get bronze(): number {
    return this._bronze;
  }

  set bronze(value: number) {
    this._bronze = value;
  }

  get silver(): number {
    return this._silver;
  }

  set silver(value: number) {
    this._silver = value;
  }

  get gold(): number {
    return this._gold;
  }

  set gold(value: number) {
    this._gold = value;
  }
}

export class GithubUser {
  private _repoCount;
  private _commitCount;


  get repoCount() {
    return this._repoCount;
  }

  set repoCount(value) {
    this._repoCount = value;
  }

  get commitCount() {
    return this._commitCount;
  }

  set commitCount(value) {
    this._commitCount = value;
  }
}

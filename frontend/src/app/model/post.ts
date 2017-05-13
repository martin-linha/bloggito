import {Comment} from "./comment";

export class Post {

  public id: number;
  public content: string;
  public perex: string;
  public title: string;
  public creator: string;
  public postedOn: Date;
  public comments: Comment[] = [];

  constructor() {
  }
}

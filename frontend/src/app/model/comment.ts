import {Post} from "./post";
export class Comment {
  author: string;
  email: string;
  content: string;
  createdOn: Date;
  post: Post;
}

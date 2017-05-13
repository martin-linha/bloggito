import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';

import {Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';
import {Post} from "../../model/post";
import {Comment} from "../../model/comment";

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {

  @Input() post: Post;
  @Output() commentAdded: EventEmitter<any> = new EventEmitter();
  comment: Comment = new Comment();

  constructor(private http: Http) {
  }

  ngOnInit() {
    console.log(this.post);
  }

  save() {
    this.http.post('http://localhost:8080/api/posts/' + this.post.id + '/comment', this.comment)
      .toPromise()
      .then(resp => {
        this.commentAdded.emit();
      });
  }
}

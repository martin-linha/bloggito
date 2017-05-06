import {Component, OnInit} from '@angular/core';
import {Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';
import {Post} from "../../model/post";


@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {

  posts: Post[];
  newPost: Post = new Post();

  constructor(private http: Http) {
  }

  ngOnInit() {
    this.getPosts()
  }

  getPosts() {
    return this.http.get('http://localhost:8080/api/posts')
      .toPromise()
      .then(resp => this.posts = resp.json())
      .catch(err => console.log(err));
  }

  savePost() {
      this.http.post('http://localhost:8080/api/posts', this.newPost)
        .toPromise()
        .then(resp => {
          this.getPosts()
        });
  }
}

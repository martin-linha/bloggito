import {Component, OnInit} from '@angular/core';
import {Http} from '@angular/http';
import {Router} from '@angular/router';

import 'rxjs/add/operator/toPromise';
import {Post} from "../../model/post";
import { AuthHttp } from 'angular2-jwt';

declare var jQuery:any;


@Component({
  selector: 'app-add-posts',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.css']
})
export class AddPostComponent implements OnInit {

  posts: Post[];
  newPost: Post = new Post();

  constructor(private http: Http, private authHttp: AuthHttp, private router: Router) {
  }

  ngOnInit() {
    this.getPosts();
    jQuery('#summernote').summernote({height: 300});
  }

  getPosts() {
    return this.http.get('http://localhost:8080/api/posts')
      .toPromise()
      .then(resp => this.posts = resp.json())
      .catch(err => console.log(err));
  }

  savePost() {
    this.newPost.content = jQuery('#summernote').summernote('code');
    this.authHttp.post('http://localhost:8080/api/posts', this.newPost)
      .toPromise()
      .then(resp => {
        this.router.navigate(['/posts', resp.json().id]);
      });
  }
}

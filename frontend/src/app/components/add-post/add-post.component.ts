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

  constructor(private http: Http, public authHttp: AuthHttp, private router: Router) {
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
    console.log(localStorage.getItem("token"));
    localStorage.setItem('token','eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ');

    this.authHttp.post('http://localhost:8080/api/posts', this.newPost)
      .toPromise()
      .then(resp => {
        this.router.navigate(['/posts', resp.json().id]);
      });
  }
}

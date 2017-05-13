import {Component, OnInit} from '@angular/core';
import {Http} from '@angular/http';
import {Router, ActivatedRoute} from '@angular/router';

import 'rxjs/add/operator/toPromise';
import {Post} from "../../model/post";
import {AuthHttp} from 'angular2-jwt';

declare var jQuery: any;


@Component({
  selector: 'app-edit-posts',
  templateUrl: './edit-post.component.html',
  styleUrls: ['./edit-post.component.css']
})
export class EditPostComponent implements OnInit {

  editPost: Post = new Post();

  constructor(private http: Http, private authHttp: AuthHttp, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.getPost();
    jQuery('#summernote').summernote({height: 300});
  }

  getPost() {
    return this.http.get('http://localhost:8080/api/posts/' + +this.route.snapshot.params['id'])
      .toPromise()
      .then(resp => {
        this.editPost = resp.json();
        jQuery('#summernote').summernote('code', this.editPost.content);
      })
      .catch(err => console.log(err));
  }

  savePost() {
    this.editPost.content = jQuery('#summernote').summernote('code');
    this.authHttp.post('http://localhost:8080/api/posts/' + this.editPost.id + '/edit', this.editPost)
      .toPromise()
      .then(resp => {
        this.router.navigate(['/posts', resp.json().id]);
      });
  }
}

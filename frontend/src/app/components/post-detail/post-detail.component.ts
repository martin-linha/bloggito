import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Post} from "../../model/post";
import {Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';
import {AuthService} from "../../services/auth.service";


@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css']
})
export class PostDetailComponent implements OnInit {
  post: Post = new Post();

  constructor(private route: ActivatedRoute,
              private router: Router,
              private http: Http,
              public authService: AuthService) {
  }

  ngOnInit() {
    this.getPost()
  }

  getPost() {
    return this.http.get('http://localhost:8080/api/posts/' + +this.route.snapshot.params['id'])
      .toPromise()
      .then(resp => {
        console.info(resp);
        this.post = resp.json()
      })
      .catch(err => console.log(err));
  }
}

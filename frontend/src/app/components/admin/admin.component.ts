import { Component, OnInit } from '@angular/core';
import {Http} from '@angular/http';

import {Post} from "../../model/post";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  posts: Post[];

  constructor(private http: Http) { }

  ngOnInit() {
    this.getPosts()

  }

  getPosts() {
    return this.http.get('/api/posts')
      .toPromise()
      .then(resp => this.posts = resp.json())
      .catch(err => console.log(err));
  }
}

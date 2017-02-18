import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

import {AppComponent} from './app.component';
import {PostsComponent} from './components/posts/posts.component';
import { PostDetailComponent } from './components/post-detail/post-detail.component';
import {AddPostComponent} from "./components/add-post/add-post.component";
import { CommentsComponent } from './components/comments/comments.component';

const appRoutes: Routes = [{path: '', component: PostsComponent},
  {path: 'posts/:id', component: PostDetailComponent},
  {path: 'add-post', component: AddPostComponent}];

@NgModule({
  declarations: [
    AppComponent,
    PostsComponent,
    PostDetailComponent,
    AddPostComponent,
    CommentsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

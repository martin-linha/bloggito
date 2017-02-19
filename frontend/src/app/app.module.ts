import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import { RouterModule, Routes } from '@angular/router';
import {Gravatar} from 'ng2-gravatar-directive';

import {AppComponent} from './app.component';
import {PostsComponent} from './components/posts/posts.component';
import { PostDetailComponent } from './components/post-detail/post-detail.component';
import {AddPostComponent} from "./components/add-post/add-post.component";
import { CommentsComponent } from './components/comments/comments.component';
import { AddCertificationComponent } from './components/add-certification/add-certification.component';
import { CertificationsComponent } from './components/certifications/certifications.component';

const appRoutes: Routes = [{path: '', component: PostsComponent},
  {path: 'posts/:id', component: PostDetailComponent},
  {path: 'add-post', component: AddPostComponent},
  {path: 'add-certification', component: AddCertificationComponent}];

@NgModule({
  declarations: [
    AppComponent,
    PostsComponent,
    PostDetailComponent,
    AddPostComponent,
    CommentsComponent,
    Gravatar,
    AddCertificationComponent,
    CertificationsComponent
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

import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {RouterModule, Routes} from '@angular/router';
import {Gravatar} from 'ng2-gravatar-directive';

import {AppComponent} from './app.component';
import {PostsComponent} from './components/posts/posts.component';
import {PostDetailComponent} from './components/post-detail/post-detail.component';
import {AddPostComponent} from "./components/add-post/add-post.component";
import {CommentsComponent} from './components/comments/comments.component';
import {AddCertificationComponent} from './components/add-certification/add-certification.component';
import {CertificationsComponent} from './components/certifications/certifications.component';
import {Http, RequestOptions} from '@angular/http';
import {AuthHttp, AuthConfig} from 'angular2-jwt';
import {LoginComponent} from './components/login/login.component';
import {AuthGuardService} from "./services/auth-guard.service";
import {AuthService} from "./services/auth.service";

const appRoutes: Routes = [{path: '', component: PostsComponent},
  {path: 'posts/:id', component: PostDetailComponent},
  {path: 'add-post', component: AddPostComponent, canActivate: [AuthGuardService]},
  {path: 'add-certification', component: AddCertificationComponent, canActivate: [AuthGuardService]},
  {path: 'login', component: LoginComponent}
];

export function authHttpServiceFactory(http: Http, options: RequestOptions) {
  return new AuthHttp(new AuthConfig(), http, options);
}
@NgModule({
  declarations: [
    AppComponent,
    PostsComponent,
    PostDetailComponent,
    AddPostComponent,
    CommentsComponent,
    Gravatar,
    AddCertificationComponent,
    CertificationsComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    {
      provide: AuthHttp,
      useFactory: authHttpServiceFactory,
      deps: [Http, RequestOptions]
    },
    AuthGuardService,
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}

import { BloggitoPage } from './app.po';

describe('bloggito App', function() {
  let page: BloggitoPage;

  beforeEach(() => {
    page = new BloggitoPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});

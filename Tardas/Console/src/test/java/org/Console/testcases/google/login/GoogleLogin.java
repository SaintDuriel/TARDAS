package org.Console.testcases.google.login;

import org.Pool.pages.Page;
import org.Pool.pages.google.GoogleHomePage;
import org.Pool.pages.google.GoogleLoginPage;

public class GoogleLogin extends LoginBase {

    Page page; 
    
    @Override
    public void loadPage() {
        page = new Page(driver, spin); 
        page.initPage(GoogleHomePage.class).loadPage().header().clickSignIn();

    }

    @Override
    public void enterUsername() {
        page.initPage(GoogleLoginPage.class)
        .fillUsername(username)
        .clickNext();
        
    }

    @Override
    public void enterPassword() {
        page.initPage(GoogleLoginPage.class)
        .fillPassword(password);
        
    }

    @Override
    public void clickLogin() {
        page.initPage(GoogleLoginPage.class)
        .clickNext();
    }

    @Override
    public void checkForErrors() {
        // TODO Auto-generated method stub
        
    }

}

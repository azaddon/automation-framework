package com.aita.pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage{
    public LoginPage(Page page) {
        super(page);
    }
    private final String txtUsername =
            "input[name='username']";

    private final String txtPassword =
            "input[name='password']";

    private final String btnLogin =
            "button[type='submit']";

    public void enterUsername(String username) {
        type(page,txtUsername,username,"Entering username");
    }

    public void enterPassword(String password) {
        type(page, txtPassword,password,"entering password");
    }

    public void clickLogin() {
        click(page,btnLogin,"Clicking on login button");
    }
    public boolean isDashboardDisplayed(){
        return true;
    }

    public void login(String username,
                      String password) {

        enterUsername(username);

        enterPassword(password);

        clickLogin();

    }
}

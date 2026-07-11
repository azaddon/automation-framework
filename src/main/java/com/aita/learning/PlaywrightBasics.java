package com.aita.learning;

import com.microsoft.playwright.*;

public class PlaywrightBasics {
    public static void main(String[] args){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page =context.newPage();
        page.navigate("https://playwright.dev");
        System.out.println(page.title());

        page.close();
        context.close();
        browser.close();
        playwright.close();

    }
}

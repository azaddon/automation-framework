package com.aita.browser;

import com.microsoft.playwright.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class BrowserManager {

    private  static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    private BrowserManager(){

    }

    public static void launchBrowser() throws IOException {
        Path videoFolder = Paths.get("videos");
        if (!Files.exists(videoFolder)) {
            Files.createDirectories(videoFolder);
        }
        playwright = Playwright.create();
        browser =BrowserFactory.createBrowser(playwright);
        context = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(videoFolder));
        page = context.newPage();
    }

    public static Page getPage(){
        return page;
    }

    public static void closeBrowser(){
        if (page !=null){
            page.close();
        }
        if(context!=null){
            context.close();
        }
        if(browser!=null){
            browser.close();
        }
        if(playwright!=null){
            playwright.close();
        }
    }
}

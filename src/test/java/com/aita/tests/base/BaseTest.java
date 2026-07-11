package com.aita.tests.base;

import com.aita.browser.BrowserManager;
import com.aita.config.ConfigManager;
import com.aita.context.FrameworkContext;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.IOException;

@Listeners(com.aita.listeners.TestListener.class)
public class BaseTest {
    protected Page page; //protected: to let it used by child class

    @BeforeMethod
    public void setUp() throws IOException {
        BrowserManager.launchBrowser();
        page = BrowserManager.getPage();
        FrameworkContext.getContext().setPage(page);

        FrameworkContext.getContext().setBrowser(ConfigManager.getBrowser());

        FrameworkContext.getContext().setEnvironment(ConfigManager.getEnvironment());

        FrameworkContext.getContext().setStartTime(System.currentTimeMillis());
    }

    @AfterMethod
    public void tearDown(){

        BrowserManager.closeBrowser();
        FrameworkContext.clear();
    }
}

package com.aita.browser;

import com.aita.config.ConfigManager;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class BrowserFactory {

    private BrowserFactory() {
    }

    public static Browser createBrowser(Playwright playwright) {

        String browserName = ConfigManager.getBrowser();

        boolean headless = Boolean.parseBoolean(ConfigManager.get("headless"));

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                                                            .setHeadless(headless);

        return switch (browserName.toLowerCase()) {

            case "firefox" ->
                    playwright.firefox().launch(options);

            case "webkit" ->
                    playwright.webkit().launch(options);

            default ->
                    playwright.chromium().launch(options);

        };

    }
}

package com.aita.wrappers;

import com.aita.loggers.FrameworkLogger;
import com.microsoft.playwright.Page;

public class PlaywrightWait {

    private final Page page;

    public PlaywrightWait(Page page){
        this.page = page;
    }

    public void waitForVisible(String locator){
        FrameworkLogger.info(
                "Waiting for : " + locator
        );
        page.locator(locator).waitFor();

    }

}
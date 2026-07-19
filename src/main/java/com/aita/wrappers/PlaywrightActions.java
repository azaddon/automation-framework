package com.aita.wrappers;

import com.aita.context.FrameworkContext;
import com.aita.loggers.FrameworkLogger;
import com.microsoft.playwright.Page;

public class PlaywrightActions {

    protected final Page page;
    protected final PlaywrightWait wait;

    public PlaywrightActions(Page page){
        this.page = page;
        this.wait = new PlaywrightWait(page);
    }
    protected void click(Page page,String locator, String stepName) {
        FrameworkLogger.info("[ACTION] " + stepName);

        FrameworkContext.getContext().setCurrentStep(stepName);
        FrameworkContext.getContext().setCurrentLocator(locator);
        wait.waitForVisible(locator);
        page.locator(locator).click();

    }
    protected void type(Page page, String locator,String value, String stepName){
        FrameworkLogger.info("STEP : " + stepName);
        FrameworkContext.getContext().setCurrentStep(stepName);
        FrameworkContext.getContext().setCurrentLocator(locator);
        wait.waitForVisible(locator);
        page.locator(locator).fill(value);
    }

    public String getText(Page page,
                          String locator,
                          String stepName) {

        FrameworkLogger.info("STEP : " + stepName);

        FrameworkContext.getContext().setCurrentStep(stepName);

        FrameworkContext.getContext().setCurrentLocator(locator);
        wait.waitForVisible(locator);
        return page.locator(locator).textContent();
    }

    public boolean isVisible(Page page,
                             String locator,
                             String stepName) {

        FrameworkLogger.info("STEP : " + stepName);

        FrameworkContext.getContext().setCurrentStep(stepName);

        FrameworkContext.getContext().setCurrentLocator(locator);
        wait.waitForVisible(locator);
        return page.locator(locator).isVisible();
    }
}

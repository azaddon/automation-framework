package com.aita.wrappers;

import com.aita.context.FrameworkContext;
import com.aita.loggers.FrameworkLogger;
import com.microsoft.playwright.Page;

public class PlaywrightActions {

    protected final Page page;
    protected static  PlaywrightWait wait;

    public PlaywrightActions(Page page){
        this.page =page;
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

    public static String getText(Page page,
                                 String locator,
                                 String stepName) {

        FrameworkLogger.info("STEP : " + stepName);

        FrameworkContext.getContext().setCurrentStep(stepName);

        FrameworkContext.getContext().setCurrentLocator(locator);
        wait.waitForVisible(locator);
        return page.locator(locator).textContent();
    }

    public static boolean isVisible(Page page,
                                    String locator,
                                    String stepName) {

        FrameworkLogger.info("STEP : " + stepName);

        FrameworkContext.getContext().setCurrentStep(stepName);

        FrameworkContext.getContext().setCurrentLocator(locator);
        wait.waitForVisible(locator);
        return page.locator(locator).isVisible();
    }
}

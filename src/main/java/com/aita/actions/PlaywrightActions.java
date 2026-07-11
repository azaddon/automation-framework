package com.aita.actions;

import com.aita.context.FrameworkContext;
import com.aita.loggers.FrameworkLogger;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PlaywrightActions {

    private PlaywrightActions() {
    }

    public static void click(Page page, String locator, String stepName) {

        FrameworkLogger.info("STEP : " + stepName);

        FrameworkContext.getContext().setCurrentStep(stepName);

        FrameworkContext.getContext().setCurrentLocator(locator);

        page.locator(locator).click();
    }

    public static void type(Page page,
                            String locator,
                            String value,
                            String stepName) {

        FrameworkLogger.info("STEP : " + stepName);

        FrameworkContext.getContext().setCurrentStep(stepName);

        FrameworkContext.getContext().setCurrentLocator(locator);

        page.locator(locator).fill(value);
    }

    public static String getText(Page page,
                                 String locator,
                                 String stepName) {

        FrameworkLogger.info("STEP : " + stepName);

        FrameworkContext.getContext().setCurrentStep(stepName);

        FrameworkContext.getContext().setCurrentLocator(locator);

        return page.locator(locator).textContent();
    }

    public static boolean isVisible(Page page,
                                    String locator,
                                    String stepName) {

        FrameworkLogger.info("STEP : " + stepName);

        FrameworkContext.getContext().setCurrentStep(stepName);

        FrameworkContext.getContext().setCurrentLocator(locator);

        return page.locator(locator).isVisible();
    }

}
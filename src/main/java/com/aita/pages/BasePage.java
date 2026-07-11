package com.aita.pages;

import com.aita.wrappers.PlaywrightActions;
import com.microsoft.playwright.Page;

public abstract class BasePage extends PlaywrightActions {

    protected BasePage(Page page) {
        super(page);

    }

}

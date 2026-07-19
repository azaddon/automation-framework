package com.aita.tests.ui;

import com.aita.assertions.FrameworkAssertions;
import com.aita.config.ConfigManager;
import com.aita.pages.LoginPage;
import com.aita.tests.base.BaseTest;
import org.testng.annotations.Test;

public class BrowserTest extends BaseTest {

    @Test
    public void verifyLogin() {
        page.navigate(ConfigManager.getBaseUrl());
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("Admin", "admin123");
        FrameworkAssertions.assertTrue(false, "Intentional Failure");
    }
}

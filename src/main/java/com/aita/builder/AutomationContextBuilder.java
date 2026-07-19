package com.aita.builder;

import com.aita.config.ConfigManager;
import com.aita.context.AutomationContext;
import com.aita.context.FrameworkContext;
import com.aita.loggers.LogCollector;
import org.testng.ITestResult;

import java.time.LocalDateTime;

public class AutomationContextBuilder {

    public static AutomationContext build(ITestResult result) {

        AutomationContext context = new AutomationContext();

        context.setTestName(result.getMethod().getMethodName());

        context.setBrowser(FrameworkContext.getContext().getBrowser());

        context.setEnvironment(FrameworkContext.getContext().getEnvironment());

        if (FrameworkContext.getContext().getPage() != null) {

            context.setUrl(FrameworkContext.getContext().getPage().url());

            context.setPageTitle(FrameworkContext.getContext().getPage().title());

        }

        context.setStepName(FrameworkContext.getContext().getCurrentStep());

        context.setLocator(FrameworkContext.getContext().getCurrentLocator());

        if (result.getThrowable() != null) {

            context.setError(result.getThrowable().getMessage());

            context.setStackTrace(result.getThrowable().toString());

        }

        context.setLogs(LogCollector.getLogs());

        context.setExecutionTime(
                System.currentTimeMillis() -
                        FrameworkContext.getContext().getStartTime()
        );

        context.setFrameworkVersion(ConfigManager.getFrameworkVersion());

        context.setPlaywrightVersion("1.54");

        context.setTimestamp(LocalDateTime.now().toString());

        context.setScreenshotPath(FrameworkContext.getContext().getScreenshotPath());

        context.setVideoPath(FrameworkContext.getContext().getVideoPath());

        return context;
    }
}

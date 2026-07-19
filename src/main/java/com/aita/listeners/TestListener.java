package com.aita.listeners;

import com.aita.ai.AIClient;
import com.aita.ai.AIRequest;
import com.aita.ai.AIResponse;
import com.aita.browser.BrowserManager;
import com.aita.builder.AutomationContextBuilder;
import com.aita.context.AutomationContext;
import com.aita.context.FrameworkContext;
import com.aita.loggers.FrameworkLogger;
import com.aita.loggers.LogCollector;
import com.aita.utils.ScreenshotManager;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result){
        LogCollector.clear();
        FrameworkLogger.info("Started : "+result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        FrameworkLogger.info("PASSED : " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        FrameworkLogger.error(
                "FAILED : " + result.getMethod().getMethodName()
        );

        String screenshot = ScreenshotManager.capture(BrowserManager.getPage(), result.getName());
        FrameworkContext.getContext().setScreenshotPath(screenshot);

        AutomationContext context = AutomationContextBuilder.build(result);
        context.setScreenshotBase64(ScreenshotManager.toBase64(screenshot));

        AIRequest request =
                new AIRequest(context);

        try {
            AIResponse response = AIClient.analyze(request);
            FrameworkLogger.info(response.toString());
        } catch (RuntimeException e) {
            FrameworkLogger.error("AI failure analysis unavailable: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        FrameworkLogger.warn("SKIPPED : " +result.getMethod().getMethodName());
    }
}

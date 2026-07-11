package com.aita.context;

import com.aita.execution.TestExecutionContext;

public class FrameworkContext {

    private static final TestExecutionContext context =
            new TestExecutionContext();

    public static TestExecutionContext getContext() {
        return context;
    }

    public static void clear() {

        context.setPage(null);
        context.setBrowser(null);
        context.setEnvironment(null);
        context.setCurrentStep(null);
        context.setCurrentLocator(null);
        context.setStartTime(0);
        context.setScreenshotPath(null);
        context.setVideoPath(context.getVideoPath());
        context.setTracePath(null);
        context.setScreenshotPath(context.getScreenshotPath());
    }
}
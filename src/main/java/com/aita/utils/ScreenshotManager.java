package com.aita.utils;

import com.microsoft.playwright.Page;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class ScreenshotManager {
    private ScreenshotManager(){}
    public static String capture(Page page, String testName) {

        try {

            Path folder = Paths.get("screenshots");

            if (!Files.exists(folder)) {
                Files.createDirectories(folder);
            }

            String timestamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss")
                            .format(new Date());

            String fileName =
                    testName + "_" + timestamp + ".png";

            Path filePath = folder.resolve(fileName);

            page.screenshot(
                    new Page.ScreenshotOptions()
                            .setPath(filePath)
                            .setFullPage(true));

            return filePath.toString();

        }
        catch (Exception e) {

            e.printStackTrace();

            return "";

        }

    }

    public static String toBase64(String screenshotPath) {
        if (screenshotPath == null || screenshotPath.isBlank()) {
            return null;
        }

        try {
            return Base64.getEncoder().encodeToString(
                    Files.readAllBytes(Paths.get(screenshotPath))
            );
        } catch (Exception e) {
            throw new IllegalStateException("Unable to encode screenshot: " + screenshotPath, e);
        }
    }
}

package com.aita.utils;

import com.microsoft.playwright.Page;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
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
}

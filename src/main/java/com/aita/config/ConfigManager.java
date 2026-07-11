package com.aita.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigManager.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("config.properties not found");
            }

            properties.load(input);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    private ConfigManager() {
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
    public static String getBrowser() {
        return get("browser");
    }

    public static String getBaseUrl() {
        return get("base.url");
    }

    public static String getEnvironment() {
        return get("environment");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(get("headless"));
    }

    public static int getTimeout() {
        return Integer.parseInt(get("timeout"));
    }

    public static int getSlowMo() {
        return Integer.parseInt(get("slowmo"));
    }

    public static boolean isAIEnabled() {
        return Boolean.parseBoolean(get("ai.enabled"));
    }

    public static String getFrameworkVersion() {
        return get("framework.version");
    }
}

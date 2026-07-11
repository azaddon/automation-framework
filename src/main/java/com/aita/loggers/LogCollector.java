package com.aita.loggers;

import java.util.ArrayList;
import java.util.List;

public class LogCollector {

    private static final List<String> logs =
            new ArrayList<>();

    public static void add(String log) {
        logs.add(log);
    }

    public static String getLogs() {
        return String.join("\n", logs);
    }

    public static void clear() {
        logs.clear();
    }
}
package com.aita.loggers;

import java.util.ArrayList;
import java.util.List;

public class LogCollector {

    private static final List<String> logs =
            new ArrayList<>();

    public static void add(String log) {
        logs.add(log);
    }

    public static List<String> getLogs() {
        return List.copyOf(logs);
    }

    public static void clear() {
        logs.clear();
    }
}

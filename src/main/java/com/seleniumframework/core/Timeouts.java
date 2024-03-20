package com.seleniumframework.core;

import java.time.Duration;

public class Timeouts {
    public static final Duration SHORT_TIMEOUT = Duration.ofSeconds(5);
    public static final Duration MEDIUM_TIMEOUT = Duration.ofSeconds(10);
    public static final Duration LONG_TIMEOUT = Duration.ofSeconds(20);
    public static final Duration VERY_LONG_TIMEOUT = Duration.ofSeconds(40);
    public static final Duration LONGEST_TIMEOUT = Duration.ofMinutes(1);
}

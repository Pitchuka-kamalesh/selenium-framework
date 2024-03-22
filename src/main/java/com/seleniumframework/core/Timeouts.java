package com.seleniumframework.core;

import java.time.Duration;
/**
 * Utility class for defining timeout durations,sleep durations.
 * @author Kamalesh
 * @version 1.0
 */
public class Timeouts {
    /**
     * Short timeout duration (5 seconds).
     */
    public static final Duration SHORT_TIMEOUT = Duration.ofSeconds(5);
    /**
     * Medium timeout duration (10 seconds).
     */
    public static final Duration MEDIUM_TIMEOUT = Duration.ofSeconds(10);
    /**
     * Long timeout duration (20 seconds).
     */
    public static final Duration LONG_TIMEOUT = Duration.ofSeconds(20);
    /**
     * Very long timeout duration (40 seconds).
     */
    public static final Duration VERY_LONG_TIMEOUT = Duration.ofSeconds(40);
    /**
     * Longest timeout duration (1 minute).
     */
    public static final Duration LONGEST_TIMEOUT = Duration.ofMinutes(1);

    /**
     * Medium sleep duration (5000 milliseconds).
     */
    public static final int MEDIUM_SLEEP = 5000;
    /**
     * Short sleep duration (2500 milliseconds).
     */
    public static final int SHORT_SLEEP = 2500;
    /**
     * Long sleep duration (7500 milliseconds).
     */
    public static final int LONG_SLEEP = 7500;
}

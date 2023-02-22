package com.publisher.utils.enums;

public enum LogReason {
    CREATE("Entity creation log"),
    UPDATE("Update info log"),
    PROGRESS("Progress update log");
    /* ... */

    public String stringValue;

    LogReason(String stringValue) {
        this.stringValue = stringValue;
    }
}

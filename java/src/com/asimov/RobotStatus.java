package com.asimov;

/**
 * Enum demonstrating enumeration types in Java
 */
public enum RobotStatus {
    ACTIVE("active"),
    IDLE("idle"),
    ERROR("error"),
    SHUTDOWN("shutdown");
    
    private final String value;
    
    // Enum constructor
    RobotStatus(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return value;
    }
}

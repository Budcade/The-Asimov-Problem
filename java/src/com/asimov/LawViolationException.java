package com.asimov;

/**
 * Custom exception class demonstrating exception handling in Java
 */
public class LawViolationException extends Exception {
    private final int lawNumber;
    
    // Constructor with parameters
    public LawViolationException(int lawNumber, String message) {
        super(String.format("Law %d Violation: %s", lawNumber, message));
        this.lawNumber = lawNumber;
    }
    
    // Getter method
    public int getLawNumber() {
        return lawNumber;
    }
}

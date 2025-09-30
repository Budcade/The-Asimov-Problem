package com.asimov;

/**
 * Command class demonstrating Java classes and encapsulation
 */
public class Command {
    // Private fields - demonstrating encapsulation
    private final String action;
    private final String target;
    private final int priority;
    private final double humanSafetyImpact;
    
    // Constructor with default values handled by overloading
    public Command(String action, String target, int priority, double humanSafetyImpact) {
        this.action = action;
        this.target = target;
        this.priority = priority;
        this.humanSafetyImpact = humanSafetyImpact;
    }
    
    // Constructor overloading - demonstrating method overloading
    public Command(String action) {
        this(action, null, 1, 0.0);
    }
    
    public Command(String action, String target) {
        this(action, target, 1, 0.0);
    }
    
    public Command(String action, String target, int priority) {
        this(action, target, priority, 0.0);
    }
    
    // Getter methods - demonstrating JavaBean pattern
    public String getAction() {
        return action;
    }
    
    public String getTarget() {
        return target;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public double getHumanSafetyImpact() {
        return humanSafetyImpact;
    }
    
    @Override
    public String toString() {
        return String.format("Command(%s, target: %s, priority: %d)", 
                           action, target, priority);
    }
}

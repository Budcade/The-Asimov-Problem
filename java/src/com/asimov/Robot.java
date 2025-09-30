package com.asimov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Asimov Problem - Java Implementation
 * Main Robot class demonstrating Java language features
 * 
 * Demonstrates:
 * - Class declaration and OOP concepts
 * - Access modifiers (public, private)
 * - Static and instance members
 * - Collections (ArrayList, HashMap)
 * - Exception handling
 * - Method overloading
 * - JavaDoc comments
 */
public class Robot {
    // Constants - demonstrating final static fields
    public static final int MAX_ENERGY = 100;
    public static final int MIN_ENERGY = 0;
    
    // Static class variable - shared across all instances
    private static int totalRobotsCreated = 0;
    
    // Private instance fields - demonstrating encapsulation
    private final String id;
    private RobotStatus status;
    private int energy;
    private final List<Command> commandHistory;
    
    /**
     * Constructor - demonstrating object initialization
     * @param robotId Unique identifier for the robot
     */
    public Robot(String robotId) {
        this.id = robotId;
        this.status = RobotStatus.ACTIVE;
        this.energy = MAX_ENERGY;
        this.commandHistory = new ArrayList<>();
        
        // Increment static counter
        totalRobotsCreated++;
    }
    
    // Getter methods - demonstrating JavaBean pattern
    public String getId() {
        return id;
    }
    
    public RobotStatus getStatus() {
        return status;
    }
    
    public int getEnergy() {
        return energy;
    }
    
    /**
     * Private method - demonstrating encapsulation
     * @param amount Energy to consume
     */
    private void consumeEnergy(int amount) {
        this.energy = Math.max(MIN_ENERGY, this.energy - amount);
        if (this.energy == 0) {
            this.status = RobotStatus.SHUTDOWN;
        }
    }
    
    /**
     * Check if command complies with Asimov's Four Laws
     * Demonstrates: conditionals, object creation, method return
     * @param command The command to check
     * @return ComplianceResult object
     */
    public ComplianceResult checkLawCompliance(Command command) {
        // Zeroth Law: Cannot harm humanity
        if ("harm_humanity".equals(command.getAction())) {
            return new ComplianceResult(false, 0, "Action would harm humanity");
        }
        
        // First Law: Cannot harm humans
        if (command.getHumanSafetyImpact() > 0.0) {
            return new ComplianceResult(false, 1, "Action would harm a human being");
        }
        
        // Third Law: Must protect own existence
        if ("self_destruct".equals(command.getAction()) && command.getPriority() < 10) {
            return new ComplianceResult(false, 3, 
                "Self-destruction violates Third Law without sufficient priority");
        }
        
        return new ComplianceResult(true, null, null);
    }
    
    /**
     * Execute a command if it complies with the laws
     * Demonstrates: exception handling, method chaining
     * @param command Command to execute
     * @return Result message
     * @throws LawViolationException if command violates a law
     */
    public String executeCommand(Command command) throws LawViolationException {
        // Guard clause - checking robot status
        if (this.status == RobotStatus.SHUTDOWN) {
            throw new LawViolationException(3, "Robot is shutdown and cannot execute commands");
        }
        
        // Check law compliance
        ComplianceResult compliance = checkLawCompliance(command);
        
        if (!compliance.isCompliant()) {
            throw new LawViolationException(compliance.getViolatedLaw(), compliance.getReason());
        }
        
        // Try-catch block - demonstrating exception handling
        try {
            String result = performAction(command);
            
            // Add to history
            this.commandHistory.add(command);
            
            // Consume energy
            consumeEnergy(5);
            
            return result;
        } catch (Exception e) {
            this.status = RobotStatus.ERROR;
            throw e;
        }
    }
    
    /**
     * Perform the actual command action
     * Demonstrates: switch statement, string formatting
     * @param command Command to perform
     * @return Action result
     */
    private String performAction(Command command) {
        String action = command.getAction().toLowerCase();
        
        // Switch statement - demonstrating control flow
        switch (action) {
            case "move":
                return String.format("Robot %s moved to %s", id, command.getTarget());
            case "pick_up":
                return String.format("Robot %s picked up %s", id, command.getTarget());
            case "scan":
                String target = command.getTarget() != null ? command.getTarget() : "surroundings";
                return String.format("Robot %s scanned the area: %s", id, target);
            case "assist_human":
                return String.format("Robot %s is assisting human with %s", id, command.getTarget());
            case "self_destruct":
                if (command.getPriority() >= 10) {
                    this.status = RobotStatus.SHUTDOWN;
                    return String.format("Robot %s executing emergency shutdown", id);
                }
                break;
            default:
                return String.format("Robot %s executed: %s", id, action);
        }
        return "";
    }
    
    /**
     * Get comprehensive status report
     * Demonstrates: Map/HashMap, boxing/unboxing
     * @return Status report as a map
     */
    public Map<String, Object> getStatusReport() {
        Map<String, Object> report = new HashMap<>();
        report.put("id", id);
        report.put("status", status.getValue());
        report.put("energy", energy);
        report.put("commandsExecuted", commandHistory.size());
        report.put("canOperate", energy > 0 && status != RobotStatus.SHUTDOWN);
        return report;
    }
    
    /**
     * String representation
     * Demonstrates: method override, String.format
     */
    @Override
    public String toString() {
        return String.format("Robot(%s, %s, %d%% energy)", id, status, energy);
    }
    
    // Static methods - demonstrating class-level operations
    
    /**
     * Get total robots created
     * @return Total number of robots
     */
    public static int getTotalRobots() {
        return totalRobotsCreated;
    }
    
    /**
     * Calculate energy cost for an action
     * Demonstrates: static method, Map usage
     * @param action Action name
     * @return Energy cost
     */
    public static int calculateEnergyCost(String action) {
        Map<String, Integer> energyCosts = new HashMap<>();
        energyCosts.put("move", 5);
        energyCosts.put("pick_up", 8);
        energyCosts.put("scan", 3);
        energyCosts.put("assist_human", 10);
        energyCosts.put("self_destruct", 100);
        
        return energyCosts.getOrDefault(action.toLowerCase(), 5);
    }
    
    /**
     * Create multiple robots
     * Demonstrates: static method, List, for loop
     * @param count Number of robots to create
     * @param prefix ID prefix
     * @return List of robots
     */
    public static List<Robot> createRobotFleet(int count, String prefix) {
        List<Robot> fleet = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String id = String.format("%s-%03d", prefix, i);
            fleet.add(new Robot(id));
        }
        return fleet;
    }
}

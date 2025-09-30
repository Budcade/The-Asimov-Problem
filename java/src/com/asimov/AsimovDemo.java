package com.asimov;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Demonstration class showing various Java language features
 * Entry point for the application
 */
public class AsimovDemo {
    
    /**
     * Main method - application entry point
     * Demonstrates: arrays, loops, exception handling, output
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("The Asimov Project - Java Implementation");
        System.out.println("=".repeat(60));
        
        // Creating robot instance
        Robot robot = new Robot("R2D2");
        System.out.println("\n1. Created: " + robot);
        
        // Creating commands - demonstrating array initialization
        Command[] safeCommands = {
            new Command("move", "kitchen", 2),
            new Command("pick_up", "book", 1),
            new Command("scan", "room", 1),
            new Command("assist_human", "cooking", 3)
        };
        
        // Demonstrating enhanced for loop
        System.out.println("\n2. Executing safe commands:");
        for (Command cmd : safeCommands) {
            try {
                String result = robot.executeCommand(cmd);
                System.out.println("   ✓ " + result);
            } catch (LawViolationException e) {
                System.out.println("   ✗ " + e.getMessage());
            }
        }
        
        // Testing law violations
        System.out.println("\n3. Testing law violations:");
        Command[] unsafeCommands = {
            new Command("harm_humanity", null, 10, 1.0),
            new Command("attack", "human", 1, 0.8),
            new Command("self_destruct", null, 1)
        };
        
        for (Command cmd : unsafeCommands) {
            try {
                robot.executeCommand(cmd);
            } catch (LawViolationException e) {
                System.out.println("   ✗ " + e.getMessage());
            }
        }
        
        // Status report - demonstrating Map iteration
        System.out.println("\n4. Robot Status Report:");
        Map<String, Object> report = robot.getStatusReport();
        for (Map.Entry<String, Object> entry : report.entrySet()) {
            System.out.println("   " + entry.getKey() + ": " + entry.getValue());
        }
        
        // Static method call
        System.out.println("\n5. Total robots created: " + Robot.getTotalRobots());
        
        // Creating a fleet
        System.out.println("\n6. Creating robot fleet:");
        List<Robot> fleet = Robot.createRobotFleet(3, "WORKER");
        for (Robot r : fleet) {
            System.out.println("   " + r);
        }
        
        System.out.println("\n7. Total robots after fleet creation: " + Robot.getTotalRobots());
        
        // Static method demonstration
        System.out.println("\n8. Energy cost calculation:");
        String[] actions = {"move", "pick_up", "scan", "assist_human"};
        for (String action : actions) {
            int cost = Robot.calculateEnergyCost(action);
            System.out.println("   " + action + ": " + cost + " energy units");
        }
        
        System.out.println("\n" + "=".repeat(60));
    }
}

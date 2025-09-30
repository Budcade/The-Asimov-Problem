package com.asimov;

/**
 * ComplianceResult class for returning law compliance check results
 * Demonstrates: Immutable data class pattern
 */
public class ComplianceResult {
    private final boolean compliant;
    private final Integer violatedLaw;
    private final String reason;
    
    public ComplianceResult(boolean compliant, Integer violatedLaw, String reason) {
        this.compliant = compliant;
        this.violatedLaw = violatedLaw;
        this.reason = reason;
    }
    
    public boolean isCompliant() {
        return compliant;
    }
    
    public Integer getViolatedLaw() {
        return violatedLaw;
    }
    
    public String getReason() {
        return reason;
    }
}

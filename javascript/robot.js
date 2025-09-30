/**
 * The Asimov Problem - JavaScript Implementation
 * Demonstrates JavaScript language features through a robot system that follows Asimov's Four Laws
 */

// Constants - Demonstrating const keyword
const MAX_ENERGY = 100;
const MIN_ENERGY = 0;

// Enums using Object.freeze - Demonstrating object immutability
const RobotStatus = Object.freeze({
    ACTIVE: 'active',
    IDLE: 'idle',
    ERROR: 'error',
    SHUTDOWN: 'shutdown'
});

/**
 * Custom Error Class - Demonstrating class inheritance
 */
class LawViolationError extends Error {
    constructor(lawNumber, message) {
        super(`Law ${lawNumber} Violation: ${message}`);
        this.name = 'LawViolationError';
        this.lawNumber = lawNumber;
    }
}

/**
 * Command Class - Demonstrating ES6 classes
 */
class Command {
    // Using modern class fields (public)
    action;
    target;
    priority;
    humanSafetyImpact;
    
    constructor(action, target = null, priority = 1, humanSafetyImpact = 0.0) {
        // Constructor with default parameters
        this.action = action;
        this.target = target;
        this.priority = priority;
        this.humanSafetyImpact = humanSafetyImpact;
    }
    
    // Method demonstrating template literals
    toString() {
        return `Command(${this.action}, target: ${this.target}, priority: ${this.priority})`;
    }
}

/**
 * Robot Class - Main implementation demonstrating OOP concepts
 * Demonstrates:
 * - Class declaration
 * - Private fields (using #)
 * - Public and private methods
 * - Getters and setters
 * - Static members
 */
class Robot {
    // Static class variable - shared across all instances
    static totalRobotsCreated = 0;
    
    // Private fields - using # prefix (ES2022)
    #id;
    #status;
    #energy;
    #commandHistory;
    
    /**
     * Constructor - demonstrating initialization
     * @param {string} robotId - Unique identifier for the robot
     */
    constructor(robotId) {
        this.#id = robotId;
        this.#status = RobotStatus.ACTIVE;
        this.#energy = MAX_ENERGY;
        this.#commandHistory = []; // Array - demonstrating array initialization
        
        // Increment static counter
        Robot.totalRobotsCreated++;
    }
    
    // Getters - Demonstrating property accessors
    get id() {
        return this.#id;
    }
    
    get status() {
        return this.#status;
    }
    
    get energy() {
        return this.#energy;
    }
    
    /**
     * Private method - demonstrating encapsulation
     * @param {number} amount - Energy to consume
     */
    #consumeEnergy(amount) {
        this.#energy = Math.max(MIN_ENERGY, this.#energy - amount);
        if (this.#energy === 0) {
            this.#status = RobotStatus.SHUTDOWN;
        }
    }
    
    /**
     * Check if command complies with Asimov's Four Laws
     * Demonstrates: object return, conditionals, arrow functions in object
     * @param {Command} command - The command to check
     * @returns {Object} Compliance result
     */
    checkLawCompliance(command) {
        // Object literal - demonstrating object creation
        const result = {
            compliant: true,
            violatedLaw: null,
            reason: null
        };
        
        // Zeroth Law: Cannot harm humanity
        if (command.action === 'harm_humanity') {
            return {
                compliant: false,
                violatedLaw: 0,
                reason: 'Action would harm humanity'
            };
        }
        
        // First Law: Cannot harm humans
        if (command.humanSafetyImpact > 0.0) {
            return {
                compliant: false,
                violatedLaw: 1,
                reason: 'Action would harm a human being'
            };
        }
        
        // Third Law: Must protect own existence
        if (command.action === 'self_destruct' && command.priority < 10) {
            return {
                compliant: false,
                violatedLaw: 3,
                reason: 'Self-destruction violates Third Law without sufficient priority'
            };
        }
        
        return result;
    }
    
    /**
     * Execute a command if it complies with the laws
     * Demonstrates: exception handling, method chaining, string interpolation
     * @param {Command} command - Command to execute
     * @returns {string} Result message
     */
    executeCommand(command) {
        // Guard clause - checking robot status
        if (this.#status === RobotStatus.SHUTDOWN) {
            throw new LawViolationError(3, 'Robot is shutdown and cannot execute commands');
        }
        
        // Check law compliance
        const compliance = this.checkLawCompliance(command);
        
        if (!compliance.compliant) {
            throw new LawViolationError(compliance.violatedLaw, compliance.reason);
        }
        
        // Try-catch block - demonstrating exception handling
        try {
            const result = this.#performAction(command);
            
            // Add to history - demonstrating array methods
            this.#commandHistory.push(command);
            
            // Consume energy
            this.#consumeEnergy(5);
            
            return result;
        } catch (error) {
            this.#status = RobotStatus.ERROR;
            throw error;
        }
    }
    
    /**
     * Perform the actual command action
     * Demonstrates: switch statement, template literals
     * @param {Command} command - Command to perform
     * @returns {string} Action result
     */
    #performAction(command) {
        const action = command.action.toLowerCase();
        
        // Switch statement - demonstrating control flow
        switch (action) {
            case 'move':
                return `Robot ${this.#id} moved to ${command.target}`;
            case 'pick_up':
                return `Robot ${this.#id} picked up ${command.target}`;
            case 'scan':
                return `Robot ${this.#id} scanned the area: ${command.target || 'surroundings'}`;
            case 'assist_human':
                return `Robot ${this.#id} is assisting human with ${command.target}`;
            case 'self_destruct':
                if (command.priority >= 10) {
                    this.#status = RobotStatus.SHUTDOWN;
                    return `Robot ${this.#id} executing emergency shutdown`;
                }
                break;
            default:
                return `Robot ${this.#id} executed: ${action}`;
        }
    }
    
    /**
     * Get comprehensive status report
     * Demonstrates: object literal shorthand, computed properties
     * @returns {Object} Status report
     */
    getStatusReport() {
        return {
            id: this.#id,
            status: this.#status,
            energy: this.#energy,
            commandsExecuted: this.#commandHistory.length,
            canOperate: this.#energy > 0 && this.#status !== RobotStatus.SHUTDOWN
        };
    }
    
    /**
     * String representation
     * Demonstrates: method override
     */
    toString() {
        return `Robot(${this.#id}, ${this.#status}, ${this.#energy}% energy)`;
    }
    
    /**
     * Static method - demonstrating class-level operations
     * @returns {number} Total robots created
     */
    static getTotalRobots() {
        return Robot.totalRobotsCreated;
    }
    
    /**
     * Static utility method
     * Demonstrates: object as map, default values
     * @param {string} action - Action name
     * @returns {number} Energy cost
     */
    static calculateEnergyCost(action) {
        // Object as dictionary/map
        const energyCosts = {
            move: 5,
            pick_up: 8,
            scan: 3,
            assist_human: 10,
            self_destruct: 100
        };
        
        // Using || for default value (or ?? for nullish coalescing)
        return energyCosts[action.toLowerCase()] ?? 5;
    }
}

/**
 * Create multiple robots
 * Demonstrates: arrow functions, array methods, spread operator
 * @param {number} count - Number of robots to create
 * @param {string} prefix - ID prefix
 * @returns {Array<Robot>} Array of robots
 */
const createRobotFleet = (count, prefix = 'ROBOT') => {
    // Array.from with arrow function - demonstrating modern JavaScript
    return Array.from({ length: count }, (_, i) => 
        new Robot(`${prefix}-${String(i).padStart(3, '0')}`)
    );
};

/**
 * Demonstration function showing various language features
 * Demonstrates: async/await ready structure, array iteration methods
 */
function demonstrateRobotOperations() {
    console.log('='.repeat(60));
    console.log('The Asimov Problem - JavaScript Implementation');
    console.log('='.repeat(60));
    
    // Creating robot instance
    const robot = new Robot('R2D2');
    console.log(`\n1. Created: ${robot}`);
    
    // Creating commands - demonstrating array of objects
    const safeCommands = [
        new Command('move', 'kitchen', 2),
        new Command('pick_up', 'book', 1),
        new Command('scan', 'room', 1),
        new Command('assist_human', 'cooking', 3)
    ];
    
    // Demonstrating for...of loop
    console.log('\n2. Executing safe commands:');
    for (const cmd of safeCommands) {
        try {
            const result = robot.executeCommand(cmd);
            console.log(`   ✓ ${result}`);
        } catch (error) {
            console.log(`   ✗ ${error.message}`);
        }
    }
    
    // Testing law violations
    console.log('\n3. Testing law violations:');
    const unsafeCommands = [
        new Command('harm_humanity', null, 10, 1.0),
        new Command('attack', 'human', 1, 0.8),
        new Command('self_destruct', null, 1)
    ];
    
    // Demonstrating forEach with arrow function
    unsafeCommands.forEach(cmd => {
        try {
            robot.executeCommand(cmd);
        } catch (error) {
            console.log(`   ✗ ${error.message}`);
        }
    });
    
    // Status report - demonstrating destructuring
    console.log('\n4. Robot Status Report:');
    const report = robot.getStatusReport();
    // Object.entries - demonstrating object iteration
    Object.entries(report).forEach(([key, value]) => {
        console.log(`   ${key}: ${value}`);
    });
    
    // Static method call
    console.log(`\n5. Total robots created: ${Robot.getTotalRobots()}`);
    
    // Creating a fleet
    console.log('\n6. Creating robot fleet:');
    const fleet = createRobotFleet(3, 'WORKER');
    // Array method - demonstrating map and forEach
    fleet.forEach(r => console.log(`   ${r}`));
    
    console.log(`\n7. Total robots after fleet creation: ${Robot.getTotalRobots()}`);
    
    // Static method demonstration
    console.log('\n8. Energy cost calculation:');
    const actions = ['move', 'pick_up', 'scan', 'assist_human'];
    // Array map - demonstrating functional programming
    actions.forEach(action => {
        const cost = Robot.calculateEnergyCost(action);
        console.log(`   ${action}: ${cost} energy units`);
    });
    
    console.log('\n' + '='.repeat(60));
}

// Node.js module check - only run if executed directly
if (typeof require !== 'undefined' && require.main === module) {
    demonstrateRobotOperations();
}

// Export for use as module - demonstrating CommonJS exports
if (typeof module !== 'undefined' && module.exports) {
    module.exports = { Robot, Command, RobotStatus, LawViolationError, createRobotFleet };
}

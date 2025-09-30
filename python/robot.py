"""
The Asimov Project - Python Implementation
Demonstrates Python language features through a robot system that follows Asimov's Four Laws
"""

# Imports - Standard library modules
from enum import Enum
from typing import List, Optional, Dict
from dataclasses import dataclass

# Enumerations - Demonstrating enum for robot status
class RobotStatus(Enum):
    """Enum demonstrating custom types and enumeration"""
    ACTIVE = "active"
    IDLE = "idle"
    ERROR = "error"
    SHUTDOWN = "shutdown"

# Data Classes - Modern Python feature for data containers
@dataclass
class Command:
    """Dataclass demonstrating modern Python syntax for structured data"""
    action: str
    target: Optional[str] = None
    priority: int = 1
    human_safety_impact: float = 0.0  # 0.0 = safe, 1.0 = harmful

# Custom Exception Classes - Demonstrating exception handling
class LawViolationError(Exception):
    """Custom exception for law violations"""
    def __init__(self, law_number: int, message: str):
        self.law_number = law_number
        super().__init__(f"Law {law_number} Violation: {message}")

# Main Robot Class - Demonstrating OOP concepts
class Robot:
    """
    Main Robot class demonstrating:
    - Class definition and constructors
    - Instance and class variables
    - Properties and methods
    - Encapsulation
    """
    
    # Class variable - shared across all instances
    total_robots_created = 0
    
    # Constants - demonstrating naming convention
    MAX_ENERGY = 100
    MIN_ENERGY = 0
    
    def __init__(self, robot_id: str):
        """Constructor - demonstrating initialization and type hints"""
        # Instance variables - unique to each instance
        self.__id = robot_id  # Private variable (name mangling)
        self.__status = RobotStatus.ACTIVE
        self.__energy = 100
        self.__command_history: List[Command] = []  # List with type hint
        
        # Increment class variable
        Robot.total_robots_created += 1
    
    # Properties - Demonstrating getters and setters
    @property
    def id(self) -> str:
        """Property demonstrating encapsulation - read-only access"""
        return self.__id
    
    @property
    def status(self) -> RobotStatus:
        """Get current status"""
        return self.__status
    
    @property
    def energy(self) -> int:
        """Get current energy level"""
        return self.__energy
    
    # Private method - demonstrating encapsulation
    def __consume_energy(self, amount: int) -> None:
        """Private method for internal use only"""
        self.__energy = max(self.MIN_ENERGY, self.__energy - amount)
        if self.__energy == 0:
            self.__status = RobotStatus.SHUTDOWN
    
    # Public methods - demonstrating the Four Laws
    def check_law_compliance(self, command: Command) -> Dict[str, any]:
        """
        Check if command complies with Asimov's Four Laws
        Demonstrates: conditionals, dictionary return, boolean logic
        """
        result = {
            "compliant": True,
            "violated_law": None,
            "reason": None
        }
        
        # Zeroth Law: Cannot harm humanity
        if command.action == "harm_humanity":
            result["compliant"] = False
            result["violated_law"] = 0
            result["reason"] = "Action would harm humanity"
            return result
        
        # First Law: Cannot harm humans or allow harm through inaction
        if command.human_safety_impact > 0.0:
            result["compliant"] = False
            result["violated_law"] = 1
            result["reason"] = "Action would harm a human being"
            return result
        
        # Second Law: Must obey orders (unless conflicts with First Law)
        # This is implicitly followed if we reach here
        
        # Third Law: Must protect own existence (unless conflicts with First/Second Law)
        if command.action == "self_destruct" and command.priority < 10:
            # Only allow if it's a high-priority command
            result["compliant"] = False
            result["violated_law"] = 3
            result["reason"] = "Self-destruction violates Third Law without sufficient priority"
            return result
        
        return result
    
    def execute_command(self, command: Command) -> str:
        """
        Execute a command if it complies with the laws
        Demonstrates: exception handling, string formatting, method calls
        """
        # Check if robot can execute commands
        if self.__status == RobotStatus.SHUTDOWN:
            raise LawViolationError(3, "Robot is shutdown and cannot execute commands")
        
        # Check law compliance
        compliance = self.check_law_compliance(command)
        
        if not compliance["compliant"]:
            # Raise custom exception
            raise LawViolationError(
                compliance["violated_law"],
                compliance["reason"]
            )
        
        # Execute command based on action - demonstrating match/case (Python 3.10+)
        try:
            result = self.__perform_action(command)
            
            # Add to history
            self.__command_history.append(command)
            
            # Consume energy
            self.__consume_energy(5)
            
            return result
            
        except Exception as e:
            # Error handling
            self.__status = RobotStatus.ERROR
            raise
    
    def __perform_action(self, command: Command) -> str:
        """
        Perform the actual command action
        Demonstrates: if/elif/else chains, string methods, f-strings
        """
        action = command.action.lower()
        
        if action == "move":
            return f"Robot {self.id} moved to {command.target}"
        elif action == "pick_up":
            return f"Robot {self.id} picked up {command.target}"
        elif action == "scan":
            return f"Robot {self.id} scanned the area: {command.target or 'surroundings'}"
        elif action == "assist_human":
            return f"Robot {self.id} is assisting human with {command.target}"
        elif action == "self_destruct" and command.priority >= 10:
            self.__status = RobotStatus.SHUTDOWN
            return f"Robot {self.id} executing emergency shutdown"
        else:
            return f"Robot {self.id} executed: {action}"
    
    def get_status_report(self) -> Dict[str, any]:
        """
        Get comprehensive status report
        Demonstrates: dictionary creation, multiple return values via dict
        """
        return {
            "id": self.id,
            "status": self.status.value,
            "energy": self.energy,
            "commands_executed": len(self.__command_history),
            "can_operate": self.energy > 0 and self.status != RobotStatus.SHUTDOWN
        }
    
    # Special methods - demonstrating Python magic methods
    def __str__(self) -> str:
        """String representation for print()"""
        return f"Robot({self.id}, {self.status.value}, {self.energy}% energy)"
    
    def __repr__(self) -> str:
        """Developer-friendly representation"""
        return f"Robot(robot_id='{self.id}')"
    
    # Class method - demonstrating class-level operations
    @classmethod
    def get_total_robots(cls) -> int:
        """Class method to get total robots created"""
        return cls.total_robots_created
    
    # Static method - demonstrating utility functions
    @staticmethod
    def calculate_energy_cost(action: str) -> int:
        """Static method for utility calculations"""
        # Dictionary demonstrating key-value mappings
        energy_costs = {
            "move": 5,
            "pick_up": 8,
            "scan": 3,
            "assist_human": 10,
            "self_destruct": 100
        }
        return energy_costs.get(action.lower(), 5)  # Default to 5

# Function outside class - demonstrating module-level functions
def create_robot_fleet(count: int, prefix: str = "ROBOT") -> List[Robot]:
    """
    Create multiple robots
    Demonstrates: list comprehension, default parameters, loops
    """
    # List comprehension - Pythonic way to create lists
    return [Robot(f"{prefix}-{i:03d}") for i in range(count)]

def demonstrate_robot_operations():
    """
    Demonstration function showing various language features
    Demonstrates: function composition, multiple concepts together
    """
    print("=" * 60)
    print("The Asimov Project - Python Implementation")
    print("=" * 60)
    
    # Creating robot instance
    robot = Robot("R2D2")
    print(f"\n1. Created: {robot}")
    
    # Creating commands using dataclass
    safe_commands = [
        Command("move", "kitchen", priority=2),
        Command("pick_up", "book", priority=1),
        Command("scan", "room", priority=1),
        Command("assist_human", "cooking", priority=3)
    ]
    
    # Demonstrating loops and iteration
    print("\n2. Executing safe commands:")
    for cmd in safe_commands:
        try:
            result = robot.execute_command(cmd)
            print(f"   ✓ {result}")
        except LawViolationError as e:
            print(f"   ✗ {e}")
    
    # Demonstrating law violations
    print("\n3. Testing law violations:")
    unsafe_commands = [
        Command("harm_humanity", priority=10, human_safety_impact=1.0),
        Command("attack", "human", human_safety_impact=0.8),
        Command("self_destruct", priority=1)
    ]
    
    for cmd in unsafe_commands:
        try:
            robot.execute_command(cmd)
        except LawViolationError as e:
            print(f"   ✗ {e}")
    
    # Status report
    print("\n4. Robot Status Report:")
    report = robot.get_status_report()
    for key, value in report.items():
        print(f"   {key}: {value}")
    
    # Demonstrating class methods
    print(f"\n5. Total robots created: {Robot.get_total_robots()}")
    
    # Creating a fleet
    print("\n6. Creating robot fleet:")
    fleet = create_robot_fleet(3, "WORKER")
    for r in fleet:
        print(f"   {r}")
    
    print(f"\n7. Total robots after fleet creation: {Robot.get_total_robots()}")
    
    # Demonstrating static method
    print("\n8. Energy cost calculation:")
    actions = ["move", "pick_up", "scan", "assist_human"]
    for action in actions:
        cost = Robot.calculate_energy_cost(action)
        print(f"   {action}: {cost} energy units")
    
    print("\n" + "=" * 60)

# Main execution block - demonstrating Python's entry point pattern
if __name__ == "__main__":
    # This block only runs when script is executed directly
    demonstrate_robot_operations()

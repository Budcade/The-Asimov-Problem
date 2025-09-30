# Java Implementation - The Asimov Project

This implementation demonstrates Java language features through a robot system that follows Asimov's Four Laws.

## Requirements

- Java Development Kit (JDK) 11 or higher
- No external dependencies required

## How to Compile and Run

### Using command line:

```bash
# Compile all Java files
javac src/com/asimov/*.java

# Run the demo
java -cp src com.asimov.AsimovDemo
```

### Using a script (Unix/Linux/Mac):

```bash
cd java
chmod +x run.sh
./run.sh
```

### Using a script (Windows):

```cmd
cd java
run.bat
```

## Language Features Demonstrated

### Core Java Concepts
- **Package Declaration**: Code organization with packages
- **Imports**: Using Java standard library classes
- **JavaDoc**: Comprehensive documentation comments
- **main() Method**: Application entry point

### Object-Oriented Programming
- **Classes**: Class declaration and instantiation
- **Constructors**: Object initialization
- **Encapsulation**: Private fields with public getters
- **Inheritance**: Exception class extends Exception
- **Method Overriding**: toString() override
- **Access Modifiers**: public, private, protected
- **Static Members**: Class variables and methods
- **Final Keyword**: Constants and immutable fields

### Data Types
- **Primitives**: int, double, boolean
- **Reference Types**: String, Objects
- **Wrapper Classes**: Integer (for nullable integers)
- **Enums**: RobotStatus enumeration
- **Arrays**: Fixed-size arrays
- **Collections**: ArrayList, HashMap

### Control Flow
- **Conditionals**: if/else statements
- **Switch Statement**: Multi-way branching
- **For Loops**: Traditional and enhanced (for-each)
- **While Loops**: (can be added)

### Collections Framework
- **List Interface**: ArrayList implementation
- **Map Interface**: HashMap implementation
- **Generics**: Type-safe collections
- **Collection Methods**: add(), size(), get(), put()
- **Iteration**: Enhanced for loop, Map.Entry

### Exception Handling
- **Try-Catch**: Exception handling blocks
- **Throws Clause**: Method signature declarations
- **Custom Exceptions**: LawViolationException
- **Exception Chaining**: super() calls

### Methods
- **Instance Methods**: Operating on object state
- **Static Methods**: Class-level utility methods
- **Method Overloading**: Multiple constructors
- **Return Types**: Various return types
- **Parameters**: Method parameters

### String Handling
- **String.format()**: Formatted strings
- **String concatenation**: Using +
- **toLowerCase()**: String manipulation
- **equals()**: String comparison
- **repeat()**: Modern Java 11+ feature

### Modern Java Features (Java 11+)
- **var keyword**: (can be added for local variables)
- **String.repeat()**: String repetition
- **Collection.of()**: (can be added)

## Code Structure

- `RobotStatus.java`: Enum for robot status
- `LawViolationException.java`: Custom exception class
- `Command.java`: Command data class with overloaded constructors
- `ComplianceResult.java`: Immutable result class
- `Robot.java`: Main robot implementation
- `AsimovDemo.java`: Demonstration and entry point

## Example Output

```
============================================================
The Asimov Project - Java Implementation
============================================================

1. Created: Robot(R2D2, active, 100% energy)

2. Executing safe commands:
   ✓ Robot R2D2 moved to kitchen
   ✓ Robot R2D2 picked up book
   ✓ Robot R2D2 scanned the area: room
   ✓ Robot R2D2 is assisting human with cooking

3. Testing law violations:
   ✗ Law 0 Violation: Action would harm humanity
   ✗ Law 1 Violation: Action would harm a human being
   ✗ Law 3 Violation: Self-destruction violates Third Law without sufficient priority

4. Robot Status Report:
   id: R2D2
   status: active
   energy: 80
   commandsExecuted: 4
   canOperate: true

5. Total robots created: 1

6. Creating robot fleet:
   Robot(WORKER-000, active, 100% energy)
   Robot(WORKER-001, active, 100% energy)
   Robot(WORKER-002, active, 100% energy)

7. Total robots after fleet creation: 4

8. Energy cost calculation:
   move: 5 energy units
   pick_up: 8 energy units
   scan: 3 energy units
   assist_human: 10 energy units

============================================================
```

## Project Structure

```
java/
├── src/
│   └── com/
│       └── asimov/
│           ├── AsimovDemo.java
│           ├── Robot.java
│           ├── Command.java
│           ├── ComplianceResult.java
│           ├── RobotStatus.java
│           └── LawViolationException.java
└── README.md
```

## Learning Resources

- [Java Tutorial (Oracle)](https://docs.oracle.com/javase/tutorial/)
- [Java Collections Framework](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/)
- [Java OOP Concepts](https://docs.oracle.com/javase/tutorial/java/concepts/)
- [Exception Handling](https://docs.oracle.com/javase/tutorial/essential/exceptions/)

## Extending This Example

Try adding:
- Interfaces (e.g., Commandable interface)
- Abstract classes
- Java Streams API for functional programming
- Lambdas and method references
- Optional<T> for null safety
- Records (Java 14+) for data classes
- Sealed classes (Java 17+)
- Unit tests with JUnit 5

# Python Implementation - The Asimov Project

This implementation demonstrates Python language features through a robot system that follows Asimov's Four Laws.

## Requirements

- Python 3.7 or higher (3.10+ for some modern features)
- No external dependencies required (uses only standard library)

## How to Run

```bash
python robot.py
```

Or make it executable:
```bash
chmod +x robot.py
./robot.py
```

## Language Features Demonstrated

### Basic Python Concepts
- **Modules and Imports**: Standard library imports (`enum`, `typing`, `dataclasses`)
- **Comments and Docstrings**: Documentation best practices
- **Type Hints**: Modern Python type annotations

### Data Types
- **Primitive Types**: `int`, `float`, `str`, `bool`
- **Collections**: `List`, `Dict`
- **Optional Types**: `Optional[T]` for nullable values
- **Enumerations**: `Enum` class for status types

### Object-Oriented Programming
- **Classes**: Class definition with `__init__` constructor
- **Instance Variables**: Private variables with name mangling (`__variable`)
- **Class Variables**: Shared across all instances
- **Properties**: Using `@property` decorator for getters
- **Methods**: Instance methods, class methods, static methods
- **Special Methods**: `__str__`, `__repr__` for string representation
- **Encapsulation**: Public, private, and protected members

### Modern Python Features
- **Dataclasses**: Using `@dataclass` decorator for data containers
- **Type Hints**: Throughout the code for better IDE support
- **F-strings**: Modern string formatting
- **List Comprehensions**: Pythonic list creation
- **Dictionary Methods**: `.get()`, `.items()`, etc.

### Control Flow
- **Conditionals**: `if/elif/else` statements
- **Loops**: `for` loops with iteration
- **Exception Handling**: `try/except` blocks
- **Early Returns**: Guard clauses

### Functions and Methods
- **Function Definition**: Regular functions with type hints
- **Default Parameters**: `prefix: str = "ROBOT"`
- **Class Methods**: `@classmethod` decorator
- **Static Methods**: `@staticmethod` decorator
- **Lambda Functions**: (can be added if needed)

### Exception Handling
- **Custom Exceptions**: `LawViolationError` class
- **Try/Except Blocks**: Proper error handling
- **Exception Inheritance**: Extending `Exception` base class

### Advanced Concepts
- **Decorators**: `@property`, `@classmethod`, `@staticmethod`
- **Context Managers**: (can be added)
- **Generators**: (can be added)
- **List/Dict Comprehensions**: Efficient data structure creation

## Code Structure

- `RobotStatus`: Enum for robot status states
- `Command`: Dataclass for command data
- `LawViolationError`: Custom exception class
- `Robot`: Main class implementing the Four Laws
- `create_robot_fleet()`: Module-level function
- `demonstrate_robot_operations()`: Demo function
- `if __name__ == "__main__":`: Entry point

## Example Output

```
============================================================
The Asimov Project - Python Implementation
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
   commands_executed: 4
   can_operate: True

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

## Learning Resources

- [Official Python Tutorial](https://docs.python.org/3/tutorial/)
- [Python Type Hints](https://docs.python.org/3/library/typing.html)
- [Python Dataclasses](https://docs.python.org/3/library/dataclasses.html)
- [Python OOP](https://docs.python.org/3/tutorial/classes.html)

## Extending This Example

Try adding:
- More command types
- Energy management system
- Robot communication between instances
- Async operations
- Database persistence
- Unit tests with `pytest`

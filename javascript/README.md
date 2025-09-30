# JavaScript Implementation - The Asimov Project

This implementation demonstrates modern JavaScript (ES6+) language features through a robot system that follows Asimov's Four Laws.

## Requirements

- Node.js 14.0 or higher (for private class fields support)
- No external dependencies required

## How to Run

```bash
node robot.js
```

Or in a browser:
```html
<script src="robot.js"></script>
```

## Language Features Demonstrated

### Modern JavaScript Syntax (ES6+)
- **ES6 Classes**: Class syntax with constructors
- **Private Fields**: Using `#` prefix (ES2022)
- **Arrow Functions**: `() => {}` syntax
- **Template Literals**: String interpolation with backticks
- **Const/Let**: Block-scoped variables
- **Default Parameters**: Function parameters with defaults
- **Destructuring**: Object and array destructuring
- **Spread Operator**: `...` for arrays/objects

### Data Types
- **Primitives**: `number`, `string`, `boolean`, `null`, `undefined`
- **Objects**: Object literals, properties, methods
- **Arrays**: Array methods and operations
- **Symbols**: (can be added)

### Object-Oriented Programming
- **Classes**: ES6 class syntax
- **Inheritance**: `extends` keyword
- **Constructors**: Class initialization
- **Getters/Setters**: Property accessors
- **Static Members**: Class-level properties and methods
- **Private Fields**: `#fieldName` syntax
- **Public Methods**: Regular class methods
- **Method Overriding**: toString()

### Control Flow
- **Conditionals**: `if/else if/else`
- **Switch Statement**: Multi-way branching
- **Loops**: `for...of`, `forEach`, `for` loops
- **Ternary Operator**: `? :` conditional
- **Nullish Coalescing**: `??` operator

### Functions
- **Function Declaration**: `function name() {}`
- **Arrow Functions**: `() => {}`
- **Default Parameters**: `param = defaultValue`
- **Rest Parameters**: `...args`
- **Higher-Order Functions**: Functions as arguments

### Arrays and Objects
- **Array Methods**: `push()`, `map()`, `filter()`, `forEach()`, `Array.from()`
- **Object Methods**: `Object.entries()`, `Object.freeze()`, `Object.keys()`
- **Spread Syntax**: `[...array]`
- **Array Destructuring**: `const [a, b] = array`
- **Object Destructuring**: `const {key} = object`

### Exception Handling
- **Try/Catch**: Exception handling blocks
- **Custom Errors**: Extending `Error` class
- **Throw**: Raising exceptions
- **Error Properties**: Custom error properties

### Modern Features
- **Template Literals**: Backtick strings with interpolation
- **Object Shorthand**: `{name, age}` instead of `{name: name, age: age}`
- **Computed Properties**: `[dynamicKey]: value`
- **String Methods**: `.repeat()`, `.padStart()`, `.toLowerCase()`
- **Math Methods**: `Math.max()`, `Math.min()`

### Module System
- **CommonJS**: `module.exports` and `require()`
- **ES Modules**: (can be added with .mjs extension)

## Code Structure

- `RobotStatus`: Frozen object acting as enum
- `LawViolationError`: Custom error class
- `Command`: Command data class
- `Robot`: Main class implementing the Four Laws
- `createRobotFleet()`: Factory function using arrow syntax
- `demonstrateRobotOperations()`: Demo function

## Example Output

```
============================================================
The Asimov Project - JavaScript Implementation
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

## Browser Compatibility

For browser usage, ensure your target browsers support:
- ES6 Classes (all modern browsers)
- Private class fields (Chrome 74+, Firefox 90+, Safari 14.1+, Edge 79+)

For older browsers, consider using Babel to transpile.

## Learning Resources

- [MDN JavaScript Guide](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide)
- [ES6 Features](http://es6-features.org/)
- [JavaScript Classes](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Classes)
- [Modern JavaScript](https://javascript.info/)

## Extending This Example

Try adding:
- Async/await for asynchronous operations
- Promises for command queuing
- Event emitters for robot communication
- Web Workers for parallel processing
- TypeScript version with strict typing
- Unit tests with Jest or Mocha

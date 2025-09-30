# Contributing to The Asimov Problem

Thank you for your interest in contributing! This project welcomes implementations in any programming language.

## How to Add a New Language

1. **Create a directory** for your language (use lowercase, e.g., `python`, `javascript`, `rust`)

2. **Implement the Robot System** that demonstrates:
   - Variables and constants
   - Data types (primitives, strings, collections)
   - Control flow (if/else, loops, switch)
   - Functions/methods
   - Classes and OOP concepts (if supported)
   - Error handling
   - Language-specific modern features

3. **Include these files**:
   - Main implementation file(s)
   - `README.md` explaining how to run the code
   - Any necessary build/config files

4. **Follow the Template**:
   Your robot implementation should include:
   ```
   - Robot class/struct with properties: id, status, energy
   - Method to check commands against the Four Laws
   - Method to execute commands
   - Method to report status
   - Demonstrate conflict resolution between laws
   - Show error handling
   ```

5. **Document Language Features**:
   - Use comments to explain what language feature is being demonstrated
   - Keep code educational and readable
   - Prefer clarity over cleverness

6. **Test Your Code**:
   - Ensure it runs without errors
   - Test the main scenarios (command execution, law conflicts)
   - Include example output in your README

## Example Structure

```
your-language/
├── README.md          # How to run + language info
├── robot.ext          # Main implementation
├── main.ext           # Entry point/demo
└── [build files]      # If needed (package.json, Cargo.toml, etc.)
```

## Code Style

- Use your language's standard conventions
- Include meaningful comments
- Keep examples simple but comprehensive
- Make it easy for beginners to understand

## Pull Request Process

1. Fork the repository
2. Create a branch for your language implementation
3. Add your implementation following the guidelines above
4. Submit a pull request with a clear description
5. Be open to feedback and suggestions

## Questions?

Open an issue if you have questions or need clarification!

## Code of Conduct

Be respectful, helpful, and constructive. This is an educational project for everyone to learn!

#!/bin/bash
# Run script for Unix/Linux/Mac

echo "Compiling Java files..."
javac src/com/asimov/*.java

if [ $? -eq 0 ]; then
    echo "Running demonstration..."
    java -cp src com.asimov.AsimovDemo
else
    echo "Compilation failed!"
    exit 1
fi

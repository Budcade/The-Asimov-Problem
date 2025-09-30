@echo off
REM Run script for Windows

echo Compiling Java files...
javac src\com\asimov\*.java

if %errorlevel% == 0 (
    echo Running demonstration...
    java -cp src com.asimov.AsimovDemo
) else (
    echo Compilation failed!
    exit /b 1
)

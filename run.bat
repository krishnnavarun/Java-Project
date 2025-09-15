@echo off
echo Compiling Java files...
javac -d bin src/app/*.java src/model/*.java src/service/*.java src/util/*.java

if %ERRORLEVEL% neq 0 (
    echo Compilation failed.
    exit /b %ERRORLEVEL%
)

echo Running program...
java -cp bin app.Main

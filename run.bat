@echo off
echo Compiling Java files...

if not exist out (
    mkdir out
)

rem Compile all Java files under src recursively
for /r src %%f in (*.java) do (
    javac -d out "%%f"
)

if %errorlevel% neq 0 (
    echo Compilation failed!
    exit /b %errorlevel%
)

echo Running program...
java -cp out util.Main

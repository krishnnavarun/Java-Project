                                  TASK MANAGEMENT SYSYTEM!

Problem Statement:

-Managing daily tasks manually often leads to missed deadlines, lost information, and poor organization. Students and professionals need a simple, easy-to-use application to store, update, and track their tasks efficiently.


Functional Requirements:
    -Add new tasks with title, description, due date.
    -View all tasks stored in the database.
    -Update task status (e.g., mark as completed).
    -Delete tasks by ID.
    -Search tasks by title or status.

Software Needs:
    -Java JDK 8+
    -MongoDB Community Edition
    -MongoDB Java Driver (for connecting Java and MongoDB)
    -IDE like Eclipse, IntelliJ, or VS Code

Hardware Needs:
    -Basic PC, 4GB RAM, 500MB storage.


OOPS Concept:
      -Encapsulation
      -Inheritance
      -Abstraction
      -Polymorphism


Structure:

TaskManager/
│── README.md                  # About the project
│── lib/                       # MongoDB driver JAR file (if not using Maven)
│── src/
│   └── com/taskmanager/
│       │── Main.java           # Program starts here, menu loop
│       │
│       ├── Task.java           # Model class (Task fields + getters/setters)
│       │
│       ├── DatabaseConnection.java   # Connects Java to MongoDB
│       │
│       ├── TaskDAO.java        # CRUD operations (Add, View, Update, Delete, Search)
│       │
│       └── ConsoleUI.java      # Handles user menu & takes input


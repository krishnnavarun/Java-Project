# JAVA PROJECT  
## TASK MANAGEMENT SYSTEM
---

The **Task Management System** is a **Java-based console application** that simplifies task creation, assignment, and tracking for teams. It provides a centralized platform to manage leaders, team members, and their tasks efficiently, with **real-time alert messages** to ensure nothing falls through the cracks.

---

## PROBLEM STATEMENT

Many teams struggle with tracking tasks, monitoring progress, and ensuring timely completion. Manual task management often leads to missed deadlines, miscommunication, and reduced productivity.

---

## SOLUTION

This system offers a centralized software platform where leaders can create tasks, assign them to members, and track progress. Members can update and complete tasks, while the system sends **alert messages** for upcoming deadlines or overdue tasks, ensuring accountability and timely completion.

---

## TARGET USERS

- **Leaders:** Create tasks, assign team members, and generate reports.  
- **Members:** View assigned tasks, update progress, and mark tasks as complete.  
- **Teams:** Improve collaboration and productivity through structured task management.

---

## FEATURES

- Leader and member login system  
- Task creation, assignment, and status updates  
- View personal or team tasks  
- Task update and completion workflow  
- **Unique Feature:** Real-time **alert messages** for pending or overdue tasks  
- Report generation for leaders (pending vs completed tasks)

---

## OOP CONCEPTS

### Main Classes

- **User (Base Class)**  
  - **Attributes:** username, password, role  
  - **Methods:** checkPassword(), showMenu()  

- **Leader (extends User)**  
  - **Attributes:** taskService, reportService  
  - **Methods:** showMenu(), createTask(), addMember()  

- **Member (extends User)**  
  - **Attributes:** taskService  
  - **Methods:** showMenu(), updateTask(), completeTask()  

- **Task**  
  - **Attributes:** id, title, description, assignee, deadline, status  
  - **Methods:** getters/setters, toString()  

- **TaskService**  
  - **Methods:** createTask(), viewTasks(), updateTask(), completeTask()  

- **ReportService**  
  - **Methods:** showReport()  

- **AuthService**  
  - **Methods:** login()  

- **MockDB**  
  - **Attributes:** users, tasks  
  - **Methods:** init()  

- **Main**  
  - **Methods:** main()  

---

### OOP Principles Applied

- **Inheritance:** Leader and Member inherit common functionality from the base User class.  
- **Polymorphism:** showMenu() behaves differently depending on user role.  
- **Association:** Tasks are associated with both Leaders (who assign) and Members (who execute).  
- **Encapsulation:** Sensitive data like passwords and task details are private and accessible through getters/setters.  

---

## UNIQUE FEATURE: ALERT MESSAGES

The system sends **alert messages** for:  

- Tasks approaching their deadline  
- Overdue tasks  
- New task assignments (optional notification for members)  

This ensures that tasks are always on the radar, improving team efficiency and accountability.

---


## UML DIAGRAM

![image alt](https://github.com/krishnnavarun/Java-Project/blob/06b11336473881f4705bd466e3604cef4f10b8fb/UML%20diagram.png)

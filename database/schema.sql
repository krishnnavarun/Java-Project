CREATE DATABASE IF NOT EXISTS task_manager;
USE task_manager;

CREATE TABLE users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  role ENUM('LEADER','MEMBER') NOT NULL
);

CREATE TABLE tasks (
  task_id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(200) NOT NULL,
  description TEXT,
  assignee VARCHAR(50),
  created_by VARCHAR(50),
  deadline DATE,
  status ENUM('PENDING','IN_PROGRESS','COMPLETED','OVERDUE') DEFAULT 'PENDING',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE logs (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50),
  action VARCHAR(255),
  timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- sample users (plain text for simplicity)
INSERT INTO users (username, password, role) VALUES
('leader1','leader123','LEADER'),
('member1','member123','MEMBER'),
('member2','member123','MEMBER');


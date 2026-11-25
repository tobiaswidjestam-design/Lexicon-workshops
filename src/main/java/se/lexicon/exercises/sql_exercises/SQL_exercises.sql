-- ==========================================
-- PART 1: DDL (Data Definition Language)
-- ==========================================

-- Exercise 1.1: Create Database
CREATE DATABASE IF NOT EXISTS school_management;
USE school_management;

-- Exercise 1.2: Create Student Table
CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    age INT
);

-- Exercise 1.3: Create Attendance Table
CREATE TABLE attendance (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    attendance_date DATE NOT NULL,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (student_id) REFERENCES student(id)
);


-- ==========================================
-- PART 2: DML (Data Manipulation Language)
-- ==========================================

-- Exercise 2.1: Insert Students
INSERT INTO student (name, email, age) VALUES
('Johan Lind', 'johan.lind@email.com', 22),
('Julia Berg', 'julia.berg@email.com', 25),
('Erik Svensson', 'erik.svensson@email.com', 20),
('Sara Holm', 'sara.holm@email.com', 28);

-- Exercise 2.2: Insert Attendance Records
INSERT INTO attendance (student_id, attendance_date, status) VALUES
(1, '2026-11-23', 'Present'),
(1, '2026-11-24', 'Present'),
(2, '2026-11-23', 'Absent'),
(3, '2026-11-23', 'Present');

-- Exercise 2.3: Update Student Age
UPDATE student
SET age = 26
WHERE name = 'Julia Berg';


-- ==========================================
-- PART 3: DQL (Data Query Language)
-- ==========================================

-- Exercise 3.1: Select All Students
SELECT * FROM student;

-- Exercise 3.2: Filter Students by Age
SELECT name, email
FROM student
WHERE age > 22;

-- Exercise 3.3: Order Students by Age
SELECT *
FROM student
ORDER BY age DESC;


-- ==========================================
-- PART 4: Joins
-- ==========================================

-- Exercise 4.1: Inner Join
SELECT s.name, a.status
FROM student s
INNER JOIN attendance a ON s.id = a.student_id;

-- Exercise 4.2: Left Join
SELECT s.name, a.status
FROM student s
LEFT JOIN attendance a ON s.id = a.student_id;


-- ==========================================
-- PART 5: Aggregation and Grouping
-- ==========================================

-- Exercise 5.1: Count Total Students
SELECT COUNT(*) AS total_students
FROM student;

-- Exercise 5.2: Group by Attendance Status
SELECT status, COUNT(*) AS total_records
FROM attendance
GROUP BY status;

-- Exercise 5.3: Count Days Present per Student
SELECT s.name, COUNT(a.id) AS days_present
FROM student s
LEFT JOIN attendance a ON s.id = a.student_id AND a.status = 'Present'
GROUP BY s.id, s.name;

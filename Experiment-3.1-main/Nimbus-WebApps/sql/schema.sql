-- SQL script to create database and sample tables for Nimbus-WebApps
CREATE DATABASE IF NOT EXISTS nimbus_lab;
USE nimbus_lab;

-- Employee table for Part B
DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
  EmpID INT PRIMARY KEY,
  Name VARCHAR(100),
  Salary DECIMAL(10,2)
);

INSERT INTO Employee (EmpID, Name, Salary) VALUES
(1, 'Aman Singh', 45000.00),
(2, 'Riya Sharma', 52000.00),
(3, 'Vikram Patel', 39000.00);

-- Attendance table for Part C
DROP TABLE IF EXISTS Attendance;
CREATE TABLE Attendance (
  id INT AUTO_INCREMENT PRIMARY KEY,
  StudentID VARCHAR(50),
  attend_date DATE,
  status VARCHAR(20)
);

-- (Optional) sample attendance
INSERT INTO Attendance (StudentID, attend_date, status) VALUES
('S101', '2025-11-01', 'Present'),
('S102', '2025-11-01', 'Absent');

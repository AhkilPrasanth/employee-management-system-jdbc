# Employee Management System (JDBC)

A console-based Employee Management System built using **Core Java, JDBC, and MySQL**.  
The application supports full CRUD operations and follows a layered DAO architecture.

---

## 🚀 Features

- Add Employee
- View All Employees
- Search Employee by ID
- Update Employee
- Delete Employee
- Uses PreparedStatement to prevent SQL Injection
- Implements DAO Design Pattern
- Proper resource handling using try-with-resources

---

## 🛠️ Technologies Used

- Java (Core)
- JDBC
- MySQL
- DAO Pattern
- Git & GitHub

---

## 🏗️ Project Architecture

The project follows a layered architecture:

- `Employee.java` → Model class
- `EmployeeDAO.java` → Handles database operations (CRUD)
- `DBConnection.java` → Manages database connection
- `MainApp.java` → Handles user interaction and menu

---

## 🗄️ Database Schema

```sql
CREATE DATABASE ems;

USE ems;

CREATE TABLE employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(100) NOT NULL,
    salary DOUBLE NOT NULL,
    dept VARCHAR(50) NOT NULL
);
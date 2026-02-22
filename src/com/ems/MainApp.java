package com.ems;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee By ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Dept: ");
                    String dept = sc.nextLine();

                    Employee emp = new Employee(id, name, salary, dept);

                    if (dao.addEmployee(emp))
                        System.out.println("Employee Added Successfully!");
                    else
                        System.out.println("Failed to Add Employee!");

                    break;

                case 2:
                    List<Employee> list = dao.getAllEmployees();

                    if (list.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        list.forEach(System.out::println);
                    }

                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();

                    Employee found = dao.getEmployeeById(searchId);

                    if (found != null)
                        System.out.println(found);
                    else
                        System.out.println("Employee not found.");

                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter New Dept: ");
                    String newDept = sc.nextLine();

                    Employee updateEmp = new Employee(updateId, newName, newSalary, newDept);

                    if (dao.updateEmployee(updateEmp))
                        System.out.println("Employee Updated Successfully!");
                    else
                        System.out.println("Update Failed!");

                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();

                    if (dao.deleteEmployee(deleteId))
                        System.out.println("Employee Deleted Successfully!");
                    else
                        System.out.println("Delete Failed!");

                    break;

                case 6:
                    System.out.println("Exiting application...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
package com.ems;

public class Employee {

    private int empId;
    private String empName;
    private double salary;
    private String dept;

    // Constructor
    public Employee(int empId, String empName, double salary, String dept) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.dept = dept;
    }

    

    public int getEmpId() {
		return empId;
	}



	public void setEmpId(int empId) {
		this.empId = empId;
	}



	public String getEmpName() {
		return empName;
	}



	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}



	public String getDept() {
		return dept;
	}



	public void setDept(String dept) {
		this.dept = dept;
	}



	// toString method
    @Override
    public String toString() {
        return empId + " | " + empName + " | " + salary + " | " + dept;
    }
}

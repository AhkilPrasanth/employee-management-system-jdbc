package com.ems;

import java.sql.*;
import java.util.*;

public class EmployeeDAO {

	public boolean addEmployee(Employee emp) {

	    String sql = "INSERT INTO employee (emp_id, emp_name, salary, dept) VALUES (?, ?, ?, ?)";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, emp.getEmpId());
	        ps.setString(2, emp.getEmpName());
	        ps.setDouble(3, emp.getSalary());
	        ps.setString(4, emp.getDept());

	        return ps.executeUpdate() > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}
	public List<Employee> getAllEmployees() {

	    List<Employee> list = new ArrayList<>();
	    String sql = "SELECT * FROM employee";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {

	        	Employee emp = new Employee(
	        	        rs.getInt("emp_id"),
	        	        rs.getString("emp_name"),
	        	        rs.getDouble("salary"),
	        	        rs.getString("dept")
	        	);

	            list.add(emp);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	public Employee getEmployeeById(int id) {

	    String sql = "SELECT * FROM employee WHERE emp_id = ?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

	        	Employee emp = new Employee(
	        	        rs.getInt("emp_id"),
	        	        rs.getString("emp_name"),
	        	        rs.getDouble("salary"),
	        	        rs.getString("dept")
	        	);

	            return emp;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return null;
	}
	public boolean updateEmployee(Employee emp) {

	    String sql = "UPDATE employee SET emp_name=?, salary=?, dept=? WHERE emp_id=?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, emp.getEmpName());
	        ps.setDouble(2, emp.getSalary());
	        ps.setString(3, emp.getDept());
	        ps.setInt(4, emp.getEmpId());

	        return ps.executeUpdate() > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}
	public boolean deleteEmployee(int id) {

	    String sql = "DELETE FROM employee WHERE emp_id = ?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, id);
	        return ps.executeUpdate() > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}
    
}

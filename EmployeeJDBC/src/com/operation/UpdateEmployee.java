package com.operation;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.utility.ConnectionJDBC;

public class UpdateEmployee 
{
	Scanner sc=new Scanner(System.in);
	public void updateName(int id) throws ClassNotFoundException, SQLException
	{
		System.out.print("Enter new name:");
		String eName=sc.next();
		CallableStatement cs=ConnectionJDBC.connection().prepareCall("{call UpdateEmployeeName(?,?)}");
		cs.setInt(1, id);
		cs.setString(2, eName);		
		cs.execute();
		System.out.println("\nName updated successfully.\n");
	}
	public void updateDesignation(int id) throws ClassNotFoundException, SQLException
	{
		System.out.print("Enter new designation:");
		String eDesignation=sc.next();
		CallableStatement cs=ConnectionJDBC.connection().prepareCall("{call UpdateEmployeeDesignation(?,?)}");
		cs.setInt(1, id);
		cs.setString(2, eDesignation);
		cs.execute();
		System.out.println("\nDesignation updated successfully.\n");
	}
	public void updateAddress(int id) throws ClassNotFoundException, SQLException
	{
		System.out.print("Enter new address:");
		String eAddress=sc.next();
		CallableStatement cs=ConnectionJDBC.connection().prepareCall("{call UpdateEmployeeAddress(?,?)}");
		cs.setInt(1, id);
		cs.setString(2, eAddress);
		cs.execute();
		System.out.println("\nAddress updated successfully.\n");
	}
	public void updateSalary(int id) throws ClassNotFoundException, SQLException
	{
		System.out.print("Enter new salary:");
		double eSalary=sc.nextDouble();
		CallableStatement cs=ConnectionJDBC.connection().prepareCall("{call UpdateEmployeeSalary(?,?)}");
		cs.setInt(1, id);
		cs.setDouble(2, eSalary);
		cs.execute();
		System.out.println("\nSalary updated successfully.\n");
	}
	public void upadateAll(int id) throws ClassNotFoundException, SQLException
	{
		System.out.print("Enter new name:");
		String eName=sc.next();
		System.out.print("Enter new designation:");
		String eDesignation=sc.next();
		System.out.print("Enter new address:");
		String eAddress=sc.next();
		System.out.print("Enter new salary:");
		double eSalary=sc.nextDouble();
		CallableStatement cs=ConnectionJDBC.connection().prepareCall("{call UpdateEmployeeAll(?,?,?,?,?)}");
		cs.setInt(1, id);
		cs.setString(2, eName);
		cs.setString(3, eDesignation);
		cs.setString(4, eAddress);
		cs.setDouble(5, eSalary);
		cs.execute();
		System.out.println("\nEmployee reocrd updated successfully.\n");
	}
}
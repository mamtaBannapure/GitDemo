package com.operation;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.model.Employee;
import com.utility.ConnectionJDBC;

public class Operation 
{
	Scanner sc=new Scanner(System.in);
	List<Employee> list=new ArrayList<>();
	public void insertData() throws ClassNotFoundException, SQLException
	{
		Employee e=new Employee();
		System.out.print("Please enter ID:");
		int id=sc.nextInt();
		e.setId(id);
		System.out.print("Please enter name:");
		String name=sc.next();
		e.setName(name);
		System.out.print("Please enter designation:");
		String designation=sc.next();
		e.setDesignation(designation);
		System.out.print("Please enter address:");
		String address=sc.next();
		e.setAddress(address);
		System.out.print("Please enter salary:");
		double salary=sc.nextDouble();
		e.setSalary(salary);
		list.add(e);
		CallableStatement cs=ConnectionJDBC.connection().prepareCall("{call InsertEmployee(?,?,?,?,?)}");
		cs.setInt(1, e.getId());
		cs.setString(2, e.getName());
		cs.setString(3, e.getDesignation());
		cs.setString(4, address);
		cs.setDouble(5, salary);
		cs.execute();
		System.out.println("\nEmployee registered successfully.\n");
	}
	public void updateData() throws ClassNotFoundException, SQLException
	{
		UpdateEmployee up=new UpdateEmployee();
		System.out.print("Please enter employee id:");
		int id=sc.nextInt();
		int flag=0;
		Statement smt=ConnectionJDBC.connection().createStatement();
		ResultSet rs=smt.executeQuery("select id from employee");
		while(rs.next())
		{
			if(id==rs.getInt(1))
				flag=1;
		}
		if(flag==1)
		{
			int n=1;
			while(n>0)
			{
				System.out.println("1-Update Name\n2-Update Designation\n3-Update Address\n4-Update Salary\n5-Update All\n6-Exit\n");
				System.out.print("Enter your choice:");
				int choice=sc.nextInt();
				switch(choice)
				{
					case 1:	up.updateName(id);
							break;
					case 2:	up.updateDesignation(id);
							break;
					case 3:	up.updateAddress(id);
							break;
					case 4:	up.updateSalary(id);
							break;
					case 5:	up.upadateAll(id);
							break;
					case 6:	System.out.println("\nRedirecting to Main Menu.\n");
							n=0;
							break;
					default:System.out.println("\nPlease enter a valid choice!!!\n");
							break;	
				}
			}
		}
		else
		{
			System.out.println("\nPlease enter a valid ID!!!\n");
		}
	}
	public void deleteData() throws ClassNotFoundException, SQLException
	{
		System.out.print("Enter Employee ID:");
		int id=sc.nextInt();
		int flag=0;
		Statement smt=ConnectionJDBC.connection().createStatement();
		ResultSet rs=smt.executeQuery("select id from employee");
		while(rs.next())
		{
			if(id==rs.getInt(1))
				flag=1;
		}
		if(flag==1)
		{
			int n=1;
			while(n>0)
			{
				System.out.println("1-Delete particular record\n2-Delete all record\n3-Exit\n");
				System.out.print("Enter your chocie:");
				int choice=sc.nextInt();
				switch(choice)
				{
					case 1:	CallableStatement cs=ConnectionJDBC.connection().prepareCall("{call deleteParticularEmployee(?)}");
							cs.setInt(1, id);
							cs.execute();
							System.out.println("\nEmployee record deleted successfully.\n");
							break;
					case 2:	CallableStatement cs1=ConnectionJDBC.connection().prepareCall("{call deleteAllEmployee()}");
							cs1.execute();
							System.out.println("\nEmployee records deleted successfully.\n");
							break;
					case 3:	System.out.println("\nRedirecting to Main Menu...\n");
							n=0;
							break;
					default:System.out.println("\nPlease enter a valid ID!!!\n");
							break;
				}
			}
		}
		else
		{
			System.out.println("\nPlease enter a valid ID!!!\n");
		}
		
	}
	public void retrieveData() throws ClassNotFoundException, SQLException
	{
		System.out.print("Enter employee ID:");
		int id=sc.nextInt();
		int flag=0;
		Statement smt=ConnectionJDBC.connection().createStatement();
		ResultSet rs=smt.executeQuery("select id from employee");
		while(rs.next())
		{
			if(id==rs.getInt(1))
				flag=1;
		}
		if(flag==1)
		{
			int n=1;
			ShowEmployee se=new ShowEmployee();
			while(n>0)
			{
				System.out.println("\n1-Show employee record acsending\n2-Show employee record decsending\n3-Show highest salary\n4-Show lowest salary\n5-Show second highest salary\n6-Show second lowest salary\n7-Exit\n");
				System.out.print("Enter your choice:");
				int choice=sc.nextInt();
				switch(choice)
				{
					case 1:	se.showNameAscending(id);
							break;
					case 2:	se.showNameDescending(id);
							break;
					case 3:	se.showHighestSalary(id);
							break;
					case 4:	se.showLowestSalary(id);
							break;
					case 5:	se.showSecondHighestSalary(id);
							break;
					case 6:	se.showSecondLowestSalary(id);
							break;
					case 7:	System.out.println("\nRedirecting to Main Menu...\n");
							n=0;
							break;
					default:System.out.println("\nPlease enter a valid choice!!!\n");
							break;	
				}
			}
		}
		else
		{
			System.out.println("\nPlease enter a valid ID!!!\n");
		}
	}
}
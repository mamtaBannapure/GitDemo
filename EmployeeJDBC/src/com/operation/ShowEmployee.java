package com.operation;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Employee;
import com.utility.ConnectionJDBC;

public class ShowEmployee 
{
	public void showNameAscending(int id) throws ClassNotFoundException, SQLException
	{
		List<Employee> list=new ArrayList<>();
		CallableStatement cs=ConnectionJDBC.connection().prepareCall("{call ShowEmpNameAscending()}");
		ResultSet rs=cs.executeQuery();
		while(rs.next())
		{
			Employee e=new Employee();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setDesignation(rs.getString(3));
			e.setAddress(rs.getString(4));
			e.setSalary(rs.getDouble(5));
			list.add(e);
		}
		System.out.println("\nID\tName\tDesignation\tAddress\tSalary");
		for(Employee e:list)
		{
			System.out.println(e.getId()+"\t"+e.getName()+"\t"+e.getDesignation()+"\t\t"+e.getAddress()+"\t"+e.getSalary());
		}
		System.out.println();
	}
	public void showNameDescending(int id) throws ClassNotFoundException, SQLException
	{
		List<Employee> list=new ArrayList<>();
		CallableStatement cs=ConnectionJDBC.connection().prepareCall("{call ShowEmpNameDescending()}");
		ResultSet rs=cs.executeQuery();
		while(rs.next())
		{
			Employee e=new Employee();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setDesignation(rs.getString(3));
			e.setAddress(rs.getString(4));
			e.setSalary(rs.getDouble(5));
			list.add(e);
		}
		System.out.println("\nID\tName\tDesignation\tAddress\tSalary");
		for(Employee e:list)
		{
			System.out.println(e.getId()+"\t"+e.getName()+"\t"+e.getDesignation()+"\t\t"+e.getAddress()+"\t"+e.getSalary());
		}
		System.out.println();
	}
	public void showHighestSalary(int id) throws SQLException, ClassNotFoundException
	{
		CallableStatement cs=ConnectionJDBC.connection().prepareCall("{call EmpHighestSalary()}");
		ResultSet rs=cs.executeQuery();
		System.out.println("\nID\tName\tDesignation\tAddress\tSalary");
		if(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t"+rs.getDouble(5));
		}
	}
	public void showLowestSalary(int id) throws SQLException, ClassNotFoundException
	{
		CallableStatement cs=ConnectionJDBC.connection().prepareCall("{call EmpLowestSalary()}");
		ResultSet rs=cs.executeQuery();
		System.out.println("\nID\tName\tDesignation\tAddress\tSalary");
		if(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t"+rs.getDouble(5));		
		}
	}
	public void showSecondHighestSalary(int id) throws SQLException, ClassNotFoundException
	{
		CallableStatement cs=ConnectionJDBC.connection().prepareCall("{call EmpSecondHighestSalary()}");
		ResultSet rs=cs.executeQuery();
		System.out.println("\nID\tName\tDesignation\tAddress\tSalary");
		if(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t"+rs.getDouble(5));		}
	}
	public void showSecondLowestSalary(int id) throws SQLException, ClassNotFoundException
	{
		CallableStatement cs=ConnectionJDBC.connection().prepareCall("{call EmpSecondLowestSalary()}");
		ResultSet rs=cs.executeQuery();
		System.out.println("\nID\tName\tDesignation\tAddress\tSalary");
		if(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t"+rs.getDouble(5));		}
	}
}
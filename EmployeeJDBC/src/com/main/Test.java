package com.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.operation.Operation;

public class Test 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{ 
		while(true)
		{
			System.out.println("*********MAIN MENU*********");
			System.out.println("1-Insert Employee Record\n2-Update Employee Record\n3-Delete Employee Record\n4-Show Employee Record\n5-Exit\n");
			System.out.print("Enter your choice:");
			@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			Operation o=new Operation();
			switch(choice)
			{
				case 1:	o.insertData();
						break;
				case 2:	o.updateData();
						break;
				case 3:	o.deleteData();
						break;
				case 4:	o.retrieveData();
						break;
				case 5:	System.out.println("\nLogged Out.\n");
						System.exit(0);
						break;
				default:System.out.println("\nPlease enter a valid choice!!!\n");
						break;
			}
		}
	}
}

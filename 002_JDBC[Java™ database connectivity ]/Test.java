package com.te.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		CrudOperationMethods methods=new CrudOperationMethods();
		System.out.println("enter case to enter perform operatino ro user database\n1)insert\n2)update\n3)fetching");
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the case you want to execute");

		int choice=s.nextInt();

		if(choice>0){
			switch(choice){
//			case 0:
//				System.exit(0);
//				System.out.println("enter valid case");
//				break;
			case 1:
				System.out.println("Insert the user details");
				methods.Insert();
				break;
			case 2:
				System.out.println("update the user details");
				methods.update();
				break;
			case 3:
				System.out.println("enter username to fetch the data");
				methods.fetching();
				break;
			case 0:
				System.exit(1);
				
			default:
				System.out.println("enter valid Case....!");
				return;
			}
		}

		//		methods.Insert();	
		//		
		//		methods.update();
		//
		//		methods.fetching();
	}
}

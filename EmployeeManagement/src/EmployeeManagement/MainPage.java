package EmployeeManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPage {

	//App page

	public static void main(String[] args) throws Exception {
		while(true) {
			Scanner sc=new Scanner(System.in);

			//			if(choice) break;
			try {
				System.out.println("\n Employee Management");
				System.out.println("1.Create, 2.Fetch, 3.Update, 4.Delete");
				int choice = sc.nextInt();
				
				switch (choice) {
				case 1:
					System.out.println("id, name, email, salary");
					int id=sc.nextInt();
					sc.nextLine();
					String name=sc.nextLine();
					String email=sc.nextLine();
					int salary=sc.nextInt();

					Employee emp=new Employee(id, name, email, salary);
					EmployeeData.createEmployee(emp);
					break;

				case 2:
					ArrayList<Employee> list=EmployeeData.fetchEmployeeData();
					for(Employee employee:list) {
						System.out.println(employee);
					}
					break;

				case 3:
					System.out.println(" name and id");
					name=sc.next();
					sc.nextLine();
					id=sc.nextInt();
					EmployeeData.Update(name, id);
					break;

				case 4:
					System.out.println("id");
					id=sc.nextInt();
					EmployeeData.deleteEmployee(id);
					break;

				default:
					System.out.println("enter valid value");
					MainPage.main(args);
					break;
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("enter proper data as given");
				MainPage.main(args);

			}
		}
	}

}












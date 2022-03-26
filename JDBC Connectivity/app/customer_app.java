package app;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.DB;
import model.customer;

public class customer_app {
	DB db;
	customer_app(){
		db= new DB();
	}
	void exitApp() {
		db.closeConnection();
		System.out.println("Customer Management App Finished");
	}
	  void createNewCustomer() {
		Scanner sc= new Scanner(System.in);
		customer customer = new customer();
		System.out.println("[Customer]Enter Customer ID: ");
		customer.cust_id = sc.nextInt();
		System.out.println("[Customer]Enter Customer Name: ");
		customer.name = sc.next();
		System.out.println("[Customer]Enter Customer Phone: ");
		customer.phone = sc.next();
		customer.rewardPoints = 100;
		//System.out.println("Enter Customer Date");
		Date date= new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		customer.inDate = formatter.format(date);
		System.out.println("[Customer]Please Review Customer Details: ");
		System.out.println(customer);
		sc.close();
		System.out.println(customer.sql());
		int result = db.executeSQL(customer.sql());
		String message = result > 0 ? customer.name+" Saved Sucessfully" : customer.name+" Not Saved";
	  }
	public static void main(String[] args) {
		//customer customer = new customer();
		System.out.println("[CD]Customer App Started[CD]");
		
		System.out.println();
		customer_app app = new customer_app();
		app.createNewCustomer();
		app.exitApp();
		
	}
}

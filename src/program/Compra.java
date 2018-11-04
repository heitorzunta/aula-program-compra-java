package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enuns.OrderStatus;

public class Compra {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dateRoman = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthday = dateRoman.parse(sc.nextLine());
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.nextLine();
		
		Client client = new Client(name, email, birthday);
		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Enter #"+i +" item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String product = sc.nextLine();
			System.out.print("Product price: ");
			double prince = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			OrderItem item = new OrderItem(quantity, new Product(product, prince));
			order.addItem(item);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY");
		System.out.println(order);
		System.out.println(client);
		System.out.println("Order items: ");
		
		for(OrderItem element: order.getItens()) {
			System.out.println(element);
		}
		
		System.out.println("Total price: $" +String.format("%.2f", order.total()));	
	
		sc.close();
	}
	
}

package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enuns.OrderStatus;

public class Order {
	private static SimpleDateFormat dateTimeRoman = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");	
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> itens = new ArrayList<>();
	private Client client;

	public Order() {
		
	}

	public Order(Date moment, OrderStatus status, Client client) {
		super();
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItens() {
		return itens;
	}

	public void addItem(OrderItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Double total() {
		double total=0.0;
		
		for(OrderItem item:itens) {
			total+=item.subTotal();
		}
		return total;
	}
	
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("Order moment: " + dateTimeRoman.format(moment) +"\n");
		info.append("Order status: " +status);
		return info.toString();
	}
}

package entities;

public class OrderItem {
	
	private Integer quantity;
	private Double price;
	private Product product;
	
	public OrderItem() {
		
	}

	public OrderItem(Integer quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
		this.price = product.getPrice();
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double subTotal() {
		return quantity * product.getPrice();	
	}
	
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append(product.getName() +", ");
		info.append("Quantity: " + quantity +", ");
		info.append("Subtotal: $" + String.format("%.2f", subTotal()));
		return info.toString();
	}
}
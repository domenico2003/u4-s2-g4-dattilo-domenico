package app.principalsClass;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order {
	private final long _id = new Random().nextLong();
	private String status;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private List<Product> products;
	private Customer customer;

	public Order(String stato, LocalDate orderDate, List<Product> products, Customer customer) {
		this.status = stato;
		this.orderDate = orderDate;
		this.deliveryDate = orderDate.plusWeeks(2);
		this.products = products;
		this.customer = customer;
	}

	public Order(String stato, List<Product> products, Customer customer) {
		this.status = stato;
		this.orderDate = LocalDate.now();
		this.deliveryDate = LocalDate.now().plusWeeks(2);
		this.products = products;
		this.customer = customer;
	}

	public long get_id() {
		return _id;
	}

	public String getStatus() {
		return status;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public String getProducts() {
		return products.toString();
	}

	public String getCustomer() {
		return customer.toString();
	}

	@Override
	public String toString() {

		return "id: " + get_id() + "; \n stato: " + getStatus() + "; \n data dell'ordine: " + getOrderDate()
				+ "; \n  data di consegna: " + getDeliveryDate() + "; \n  prodotti: " + getProducts()
				+ "; \n  consumatore: " + getCustomer();
	}
}

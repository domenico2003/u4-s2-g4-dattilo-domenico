package app.principalsClass;

import java.util.Random;

public class Product {
	private long _id = new Random().nextLong();
	private String name;
	private String category;
	private double price;

	public Product(String name, String category, double price) {
		this.category = category;
		this.name = name;
		this.price = price;
	}

	public long get_id() {
		return _id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public void SetPrice(double prezzo) {
		this.price = prezzo;
	}

	@Override
	public String toString() {

		return "id: " + get_id() + "; nome: " + getName() + "; categoria: " + getCategory() + "; prezzo: " + getPrice();
	}
}

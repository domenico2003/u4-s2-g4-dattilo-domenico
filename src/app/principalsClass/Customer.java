package app.principalsClass;

import java.util.Random;

import app.principalsClass.exceptions.ThierNotValidException;

public class Customer {
	private long _id = new Random().nextLong();;
	private String name;
	private int tier;

	public Customer(String name, int tier) throws ThierNotValidException {
		this.name = name;
		setTier(tier);
	}

	public long get_id() {
		return _id;
	}

	public String getName() {
		return name;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int grado) throws ThierNotValidException {
		if (grado >= 0 && grado <= 5) {
			this.tier = grado;
		} else {
			throw new ThierNotValidException("il grado non é compreso tra 0 e 5");
		}
	}

	@Override
	public String toString() {

		return "id: " + get_id() + "; nome: " + getName() + "; grado: " + getTier();
	}
}

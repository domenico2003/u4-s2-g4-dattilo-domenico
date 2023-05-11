package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import app.principalsClass.Customer;
import app.principalsClass.Order;
import app.principalsClass.Product;
import app.principalsClass.exceptions.ThierNotValidException;

public class MainClass {

	public static void main(String[] args) {
		LocalDate data1 = LocalDate.of(2021, 2, 15);
		LocalDate data2 = LocalDate.of(2021, 3, 30);
		LocalDate data3 = LocalDate.of(2021, 4, 1);

		List<Product> prodotti1 = new ArrayList<>();
		List<Product> prodotti2 = new ArrayList<>();
		List<Product> prodotti3 = new ArrayList<>();
		List<Product> prodotti4 = new ArrayList<>();
		List<Product> prodotti5 = new ArrayList<>();
		List<Product> prodotti6 = new ArrayList<>();

		prodotti1.add(new Product("libro meno costoso", "Books", 10));
		prodotti1.add(new Product("film meno costoso", "Film", 25));
		prodotti1.add(new Product("il libro più costoso", "Books", 125));
		prodotti1.add(new Product("il fil più costoso", "Film", 100));
		prodotti1.add(new Product("il libro costoso", "Books", 165));

		prodotti2.add(new Product("prodotti2", "Baby", 10));
		prodotti2.add(new Product("prod", "Books", 100));
		prodotti2.add(new Product("prodotti2.1", "Baby", 30));

		prodotti3.add(new Product("film1", "Film", 3));
		prodotti3.add(new Product("lobro", "Books", 60));
		prodotti3.add(new Product("telefilm", "Film", 7));

		prodotti4.add(new Product("prodotti4", "Baby", 11));
		prodotti4.add(new Product("baby", "Books", 5));
		prodotti4.add(new Product("libro", "Books", 100));

		prodotti5.add(new Product("prodotto", "Boys", 10));
		prodotti5.add(new Product("riprodotto", "Film", 6.99));
		prodotti5.add(new Product("azione", "Boys", 250));

		prodotti6.add(new Product("biberon", "Baby", 3.3));
		prodotti6.add(new Product("non saprei", "Baby", 6.6));
		prodotti6.add(new Product("articolo 3", "Baby", 9.9));

		Customer client1 = null, client2 = null, client3 = null, client4 = null, client5 = null, client6 = null;

		try {
			client1 = new Customer("Domenico", 4);
			client2 = new Customer("Daniele", 2);
			client3 = new Customer("Giorgia", 1);
			client4 = new Customer("Maria", 2);
			client5 = new Customer("Stefano", 3);
			client6 = new Customer("Giulia", 2);
		} catch (ThierNotValidException e) {

			System.out.println(e.getMessage());
		}

		List<Order> ordini = new ArrayList<>();

		Order ordine1 = new Order("approvato", data1, prodotti1, client5);
		Order ordine2 = new Order("in attesa", prodotti2, client3);
		Order ordine3 = new Order("in consegna", data2, prodotti3, client6);
		Order ordine4 = new Order("consegnato", data3, prodotti4, client2);
		Order ordine5 = new Order("in partenza", prodotti5, client1);
		Order ordine6 = new Order("sta viaggiando", prodotti6, client4);

		ordini.add(ordine1);
		ordini.add(ordine2);
		ordini.add(ordine3);
		ordini.add(ordine4);
		ordini.add(ordine5);
		ordini.add(ordine6);

//		ordini.forEach(ordine -> {
//			System.out.println(ordine);
//			System.out.println();
//		});

		List<Product> libriConSuperPrezzo = esercizio1(prodotti1);

//		libriConSuperPrezzo.forEach(prodotto -> {
//			System.out.println(prodotto);
//			System.out.println();
//		});

		List<Order> OrdiniPerBaby = esercizio2(ordini);

//		OrdiniPerBaby.forEach(prodotto -> {
//			System.out.println(prodotto);
//			System.out.println();
//		});

		List<Product> prodottiscontati = esercizio3(prodotti5);

//		prodottiscontati.forEach(prodotto -> {
//			System.out.println(prodotto);
//			System.out.println();
//		});

		esercizio4();
	}

	public static List<Product> esercizio1(List<Product> prodotti) {
		List<Product> bookOverPrice = prodotti.stream()
				.filter(prodotto -> prodotto.getCategory() == "Books" && prodotto.getPrice() >= 100).toList();
		return bookOverPrice;
	}

	public static List<Order> esercizio2(List<Order> ordini) {
		List<Order> ordiniCategoriaBaby = ordini.stream().filter(ordine -> ordine.getProducts().contains("Baby"))
				.toList();
		return ordiniCategoriaBaby;
	}

	public static List<Product> esercizio3(List<Product> prodotti) {
		List<Product> prodottiScontati = prodotti.stream().filter(prodotto -> prodotto.getCategory() == "Boys")
				.map(prodotto -> {
					prodotto.SetPrice(prodotto.getPrice() - (prodotto.getPrice() * 0.1));
					return prodotto;
				}).toList();
		return prodottiScontati;
	}

	public static void esercizio4() {

	}

}

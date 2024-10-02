import e_commerceClasses.Customer;
import e_commerceClasses.Order;
import e_commerceClasses.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("------Esercizio 1------");

        Product prod1 = new Product("Books", 1L, "Start Java", 120.00);
        Product prod2 = new Product("Books", 2L, "Python Guide", 160.00);
        Product prod3 = new Product("E-cig", 3L, "Aspire Flexius", 30.00);
        Product prod4 = new Product("Books", 4L, "Trading Guide", 1.00);

        List<Product> prodotti = List.of(prod1, prod2, prod3, prod4);
        List<Product> prodottiFiltrati = prodotti.stream().filter(prod -> prod.getCategory().equals("Books")).filter(product -> product.getPrice() > 100).collect(Collectors.toList());

        prodottiFiltrati.forEach(product -> {
            System.out.println(product);
        });

        System.out.println("------Esercizio 2------");

        Product p1 = new Product("Baby", 1L, "Pampers", 25.00);
        Product p2 = new Product("Book", 2L, "ExBook", 5.00);
        Product p3 = new Product("Baby", 3L, "Fasciatoio", 75.00);
        Product p4 = new Product("Toy", 4L, "Rubick Cube", 7.50);

        Customer cliente1 = new Customer(1L, "Bobby", 1);
        Customer cliente2 = new Customer(2L, "Federica", 2);

        Order pacco1 = new Order(1L, "Consegnato", LocalDate.now(), List.of(p1, p4), cliente1);
        Order pacco2 = new Order(2L, "In Elaborazione...", LocalDate.now(), List.of(p2), cliente2);
        Order pacco3 = new Order(3L, "Spedito", LocalDate.now(), List.of(p3), cliente1);

        List<Order> ordini = List.of(pacco1, pacco2, pacco3);

        List<Order> ordiniFiltrati = ordini.stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals("Baby"))).toList();

        ordiniFiltrati.forEach(order -> {
            System.out.println(order);
        });

        System.out.println("------Esercizio 3------");

        Product product1 = new Product("Boys", 1L, "Fankopop", 50.00);
        Product product2 = new Product("Boys", 2L, "Led per Interni Auto", 80.00);
        Product product3 = new Product("Elettronica", 3L, "Laptotp", 1500.00);
        Product product4 = new Product("Book", 4L, "La Storia del...", 20.00);

        List<Product> products = List.of(product1, product2, product3, product4);

        List<Product> prodottiInSconto = products.stream().
                filter(product -> product.getCategory().equals("Boys")).
                map(product -> new Product(product.getCategory(),
                        product.getId(),
                        product.getName(),
                        product.getPrice() * 0.9)).toList();

        prodottiInSconto.forEach(product -> System.out.println(product));

        System.out.println("------Esercizio 4------");

        Customer customer1 = new Customer(1L, "Antonio", 1);
        Customer customer2 = new Customer(2L, "Pandolfo", 2);

        Product articolo1 = new Product("Baby", 1L, "Shampoo per bambini", 5.25);
        Product articolo2 = new Product("Elettronica", 2L, "PS5 PRO", 800.00);
        Product articolo3 = new Product("Book", 3L, "Story Book", 0.50);
        Product articolo4 = new Product("Toys", 4L, "Action-Figure", 15.25);

        Order order1 = new Order(1L, "Spedito", LocalDate.of(2021, 2, 15), List.of(articolo1, articolo4), customer2);
        Order order2 = new Order(2L, "In Elaborazione", LocalDate.of(2021, 3, 10), List.of(articolo2), customer2);
        Order order3 = new Order(3L, "Consegnato", LocalDate.of(2021, 4, 5), List.of(articolo3), customer1);

        List<Order> listaOrdini = List.of(order1, order2, order3);

        LocalDate inizioIntervallo = LocalDate.of(2021, 2, 1);
        LocalDate fineIntervallo = LocalDate.of(2021, 4, 1);

        List<Product> prodottiOrdinatiNellIntervallo = listaOrdini.stream().
                filter(order -> order.getCustomer().getTier() == 2).
                filter(order -> order.getOrderDate().isAfter(inizioIntervallo) &&
                        order.getOrderDate().isBefore(fineIntervallo)).
                flatMap(order -> order.getProducts().stream()).toList();

        prodottiOrdinatiNellIntervallo.forEach(product -> System.out.println(product));


    }
}
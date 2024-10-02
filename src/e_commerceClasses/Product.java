package e_commerceClasses;

public class Product {
    private long id;
    private String name;
    private String category;
    private double price;

    public Product(String category, long id, String name, double price) {
        this.category = category;
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "category='" + category + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

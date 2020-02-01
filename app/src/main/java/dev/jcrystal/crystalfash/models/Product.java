package dev.jcrystal.crystalfash.models;

public class Product {

    private String name;
    private String category ;
    private String description ;
    private String image;
    private double price;
    private double oldPrice;
    private long id;

    public Product() {
    }

    public Product(String name, String category, String description, String image, double price, double oldPrice, long id) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.image = image;
        this.price = price;
        this.oldPrice = oldPrice;
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

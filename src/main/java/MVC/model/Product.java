package MVC.model;

public class Product {
    private int id;
    private String name;
    private String brand;
    private Category category;
    private Shop shop;
    private String image;
    private String price;
    private String description;
    private String details;
    private int quantity;
    
    public Product(){};

    public Product(int i, String name, Category category, Shop shop, String image, String price, String price1, String describe, String detail) {
    }

    public Product(int id, String name, Category category, Shop shop, String image, String price, String description, String details) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.shop = shop;
        this.image = image;
        this.price = price;
        this.description = description;
        this.details = details;
        this.quantity = quantity;
    }

    public Product(int id, String name, Category category, Shop shop, String image, String price, String description, String details, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.shop = shop;
        this.image = image;
        this.price = price;
        this.description = description;
        this.details = details;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDecription() {
        return description;
    }

    public void setDecription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Product(int anInt) {
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Product(int id, String name, String brand, Category category, Shop shop, String image, String price,
                   String description, String details, int quantity) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.shop = shop;
        this.image = image;
        this.price = price;
        this.description = description;
        this.details = details;
        this.quantity = quantity;
    }
}

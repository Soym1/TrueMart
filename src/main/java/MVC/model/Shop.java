package MVC.model;

public class Shop {
    private int id;
    private Users users;
    private String shop_name;
    private String address;
    private Shopper_Details shopper_details;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Shopper_Details getShopper_details() {
        return shopper_details;
    }

    public void setShopper_details(Shopper_Details shopper_details) {
        this.shopper_details = shopper_details;
    }

    public Shop(int anInt) {
    }

    public Shop(int id, Users users, String shop_name, String address) {
        this.id = id;
        this.users = users;
        this.shop_name = shop_name;
        this.address = address;
    }

    public Shop(int id, Users users, String shop_name, String address, Shopper_Details shopper_details) {
        this.id = id;
        this.users = users;
        this.shop_name = shop_name;
        this.address = address;
        this.shopper_details = shopper_details;
    }
}

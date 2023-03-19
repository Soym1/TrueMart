package MVC.model;


import java.util.Date;

public class Shopper_Details {
    private int id;
    private String email;
    private String phonenumber;
    private String address;
    private String category;
    private int quantity;
    private Date date_created;
    private String avatar;



    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Shopper_Details(int id, String email, String phonenumber, String address, String category, int quantity, Date date_created, String avatar) {
        this.id = id;
        this.email = email;
        this.phonenumber = phonenumber;
        this.address = address;
        this.category = category;
        this.quantity = quantity;
        this.date_created = date_created;
        this.avatar = avatar;
    }
}

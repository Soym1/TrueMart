package MVC.model;

public class OrderItem {
    private int id;
    private int userId;
    private String date;

    private double totalMoney;

    public OrderItem() {

    }

    public OrderItem(int id, int userId, String date, double totalMoney) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.totalMoney = totalMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
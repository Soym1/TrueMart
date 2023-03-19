package MVC.model;

import java.sql.Timestamp;

public class Review {
    private int id;
    private String user_review;

    private String email;
    private Product product;
    private String content;
    private float rating;

    private Timestamp date;

    public Review(int id, String user_review, Product product, String string, float aFloat) {
        this.id = id;
        this.user_review = user_review;
        this.email = email;
        this.product = product;
        this.content = content;
        this.rating = rating;
        this.date = date;
    }

    public Review(int id, String user_review, String email, Product product, String content, float rating, Timestamp date) {
        this.id = id;
        this.user_review = user_review;
        this.email = email;
        this.product = product;
        this.content = content;
        this.rating = rating;
        this.date = date;
    }

    public String getUser_review() {
        return user_review;
    }

    public void setUser_review(String user_review) {
        this.user_review = user_review;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_review;
    }

    public void setUser_name(String user_review) {
        this.user_review = user_review;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }

    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", user_review'" + user_review + '\'' +
                ", email='" + email + '\'' +
                ", product=" + product.getId() +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                ", date=" + date +
                '}';
    }
}

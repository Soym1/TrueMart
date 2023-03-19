package MVC.respository;

import MVC.model.Review;
import MVC.model.Shop;

import java.util.ArrayList;
import java.util.List;

public interface IReviewRepository {
    List<Review> getReviews(int pid);

    void addRe(Review reviewmain);

    ArrayList<Review> listReviewShop(Shop shop);

    ArrayList<Review> listAll();

    int del(int id);
}

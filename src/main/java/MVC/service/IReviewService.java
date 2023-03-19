package MVC.service;

import MVC.model.Review;
import MVC.model.Shop;

import java.util.ArrayList;
import java.util.List;

public interface IReviewService {
    List<Review> getReviews(int pid);

    void addRe(Review reviewmain);

    ArrayList<Review> listAll();

    ArrayList<Review> listReviewShop(Shop shop);

    int del(int id);
}

package MVC.service.Impl;

import MVC.model.Review;
import MVC.model.Shop;
import MVC.respository.IReviewRepository;
import MVC.respository.impl.ReviewRepository;
import MVC.service.IReviewService;

import java.util.ArrayList;
import java.util.List;

public class ReviewService implements IReviewService {
    private IReviewRepository iReviewRepository = new ReviewRepository();

    @Override
    public List<Review> getReviews(int pid) {
        return iReviewRepository.getReviews(pid);
    }

    @Override
    public void addRe(Review reviewmain) {
        iReviewRepository.addRe(reviewmain);
    }

    @Override
    public ArrayList<Review> listAll() {
        return iReviewRepository.listAll();
    }

    @Override
    public ArrayList<Review> listReviewShop(Shop shop) {
        return iReviewRepository.listReviewShop(shop);
    }

    @Override
    public int del(int id) {
        return iReviewRepository.del(id);
    }
}

package MVC.respository.impl;

import MVC.model.Product;
import MVC.model.Review;
import MVC.model.Shop;
import MVC.respository.IReviewRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewRepository implements IReviewRepository {
    @Override
    public List<Review> getReviews(int pid) {
        ArrayList<Review> listReviews = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "select * from review where product_id = ?;");
            preparedStatement.setInt(1,pid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String user_review = resultSet.getString(2);
                String email_review = resultSet.getString(3);
                Product product = new Product(resultSet.getInt(4),null,null,null,null,null,null,null);
                String content = resultSet.getString(5);
                Float rating = resultSet.getFloat(6);
                Timestamp post_date = resultSet.getTimestamp(7);
                Review review = new Review(id,user_review,email_review,product,content,rating,post_date);
                listReviews.add(review);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listReviews;
    }

    @Override
    public void addRe(Review reviewmain) {
        int result = 0;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "insert into review(user_review,email_review,product_id,content,rating,post_date) values\n" +
                            "(?,?,?,?,?,?)");
            preparedStatement.setString(1,reviewmain.getUser_review());
            preparedStatement.setString(2,reviewmain.getEmail());
            preparedStatement.setInt(3,reviewmain.getProduct().getId());
            preparedStatement.setString(4,reviewmain.getContent());
            preparedStatement.setFloat(5,reviewmain.getRating());
            preparedStatement.setTimestamp(6,reviewmain.getDate());
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public ArrayList<Review> listReviewShop(Shop shop) {
        ArrayList<Review> listReviews = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "select * from review \n" +
                            "inner join product\n" +
                            "on review.product_id = product.id\n" +
                            "inner join shop\n" +
                            "on product.shop_id = shop.id\n" +
                            "where shop_id = ?;");
            preparedStatement.setInt(1,shop.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String user_review = resultSet.getString(2);
                String email_review = resultSet.getString(3);
                Product product = new Product(resultSet.getInt(4),resultSet.getString(9),null,null,null,null,null,null);
                String content = resultSet.getString(5);
                Float rating = resultSet.getFloat(6);
                Timestamp post_date = resultSet.getTimestamp(7);
                Review review = new Review(id,user_review,email_review,product,content,rating,post_date);
                listReviews.add(review);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listReviews;
    }

    @Override
    public ArrayList<Review> listAll() {
        ArrayList<Review> listReviews = new ArrayList<>();
        try {
            Statement statement = BaseRespository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from review \n" +
                            "inner join product\n" +
                            "on review.product_id = product.id");
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String user_review = resultSet.getString(2);
                String email_review = resultSet.getString(3);
                Product product = new Product(resultSet.getInt(4),resultSet.getString(9),null,null,null,null,null,null);
                String content = resultSet.getString(5);
                Float rating = resultSet.getFloat(6);
                Timestamp post_date = resultSet.getTimestamp(7);
                Review review = new Review(id,user_review,email_review,product,content,rating,post_date);
                listReviews.add(review);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listReviews;
    }

    @Override
    public int del(int id) {
        int reuslt = 0;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "DELETE FROM review WHERE id = ?;"
            );
            preparedStatement.setInt(1,id);
            reuslt = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reuslt;
    }
}

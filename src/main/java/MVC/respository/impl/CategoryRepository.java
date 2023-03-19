package MVC.respository.impl;

import MVC.model.Category;
import MVC.respository.ICategoryRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    @Override
    public List<Category> ListCate() {
        List<Category> categorysList = new ArrayList<>();
        try {
            Statement statement = BaseRespository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from category order by id ;");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String category_name = resultSet.getString("category_name");
                Category category = new Category(id,category_name);
                categorysList.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categorysList;
    }

    @Override
    public int creat(String category_name) {
        int reuslt = 0;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "insert into category(category_name) values\n" +
                            "(?)"
            );
            preparedStatement.setString(1, category_name);
            reuslt = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reuslt;
    }

    @Override
    public Category findAll(int id) {
        Category category = null;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "select * from category where id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String category_name = resultSet.getString("category_name");
                category = new Category(id,category_name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }

    @Override
    public int edit(Category category) {
        int reuslt = 0;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "UPDATE category\n" +
                            "SET category_name = ?" +
                            "WHERE id = ?;"
            );
            preparedStatement.setString(1, category.getCategory_name());
            preparedStatement.setInt(2,category.getId());
            reuslt = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reuslt;
    }

    @Override
    public int del(int id) {
        int reuslt = 0;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "DELETE FROM category WHERE id = ?;"
            );
            preparedStatement.setInt(1,id);
            reuslt = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reuslt;
    }

    @Override
    public int numAll() {
        int resuft = 0;
        try {
            Statement statement = BaseRespository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select count(id) as num from category;");
            if(resultSet.next()){
                resuft = resultSet.getInt("num");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resuft;
    }
}

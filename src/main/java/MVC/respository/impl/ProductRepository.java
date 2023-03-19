package MVC.respository.impl;

import MVC.model.*;
import MVC.respository.IProductRepository;
import MVC.util.DefineUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> productList() {
        List<Product> productList = new ArrayList<>();
        try {
            Statement statement = BaseRespository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select product.id , name, category_id, shop_id, image, price, description, details , shop_name , category_name\n" +
                            "from product \n" +
                            "inner join category\n" +
                            "on product.category_id = category.id\n" +
                            "inner join shop\n" +
                            "on product.shop_id = shop.id;");
            while (resultSet.next()){
                int id = resultSet.getInt("product.id");
                String name = resultSet.getString("name");
                Category category = new Category(resultSet.getInt("category_id"),resultSet.getString("category_name"));
                Shop shop = new Shop(resultSet.getInt("shop_id"), null, resultSet.getString("shop_name"),null);
                String image = resultSet.getString("image");
                String price = resultSet.getString("price");
                String decription = resultSet.getString("description");
                String details = resultSet.getString("details");
                Product product = new Product(id,name,category,shop,image,price,decription,details);
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public int creat(Product product) {
        int reuslt = 0;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "INSERT INTO product ( Name, brand, category_id, shop_id, image, price, description, details, quantity) VALUES \n" +
                            "(?, '', ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getCategory().getId());
            preparedStatement.setInt(3, product.getShop().getId());
            preparedStatement.setString(4, product.getImage());
            preparedStatement.setString(5, product.getPrice());
            preparedStatement.setString(6, product.getDecription());
            preparedStatement.setString(7, product.getDetails());
            preparedStatement.setInt(8,product.getQuantity());
            reuslt = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reuslt;
    }

    @Override
    public Product findAll(int id) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "select product.id , name, category_id, shop_id, image, price, description, details , shop_name ,quantity , category_name\n" +
                            "from product \n" +
                            "inner join category\n" +
                            "on product.category_id = category.id\n" +
                            "inner join shop\n" +
                            "on product.shop_id = shop.id \n" +
                            "where product.id = ?;");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String name = resultSet.getString("name");
                Category category = new Category(resultSet.getInt("category_id"),resultSet.getString("category_name"));
                Shop shop = new Shop(resultSet.getInt("shop_id"), null, resultSet.getString("shop_name"),null);
                String image = resultSet.getString("image");
                String price = resultSet.getString("price");
                String decription = resultSet.getString("description");
                String details = resultSet.getString("details");
                int quantity = resultSet.getInt("quantity");
                product = new Product(id,name,category,shop,image,price,decription,details,quantity);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public int edit(Product product) {
        int reuslt = 0;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "UPDATE product\n" +
                            "SET name = ?, category_id = ?, image = ?, price = ?, description = ?, details = ?,quantity = ?\n" +
                            "WHERE id = ?;"
            );
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getCategory().getId());
            preparedStatement.setString(3, product.getImage());
            preparedStatement.setString(4, product.getPrice());
            preparedStatement.setString(5, product.getDecription());
            preparedStatement.setString(6, product.getDetails());
            preparedStatement.setInt(7,product.getQuantity());
            preparedStatement.setInt(8, product.getId());
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
                    "DELETE FROM product WHERE id = ?;"
            );
            preparedStatement.setInt(1,id);
            reuslt = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reuslt;
    }

    @Override
    public ArrayList<Product> productShop(int id) {
        ArrayList<Product> listP = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "select product.id , name, category_id, shop_id, image, price, description, details , shop_name , category_name\n" +
                            "from product \n" +
                            "inner join category\n" +
                            "on product.category_id = category.id\n" +
                            "inner join shop\n" +
                            "on product.shop_id = shop.id \n" +
                            "where shop.id = ?;");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int pid = resultSet.getInt("product.id");
                String name = resultSet.getString("name");
                Category category = new Category(resultSet.getInt("category_id"),resultSet.getString("category_name"));
                Shop shop = new Shop(id, null, resultSet.getString("shop_name"),null);
                String image = resultSet.getString("image");
                String price = resultSet.getString("price");
                String decription = resultSet.getString("description");
                String details = resultSet.getString("details");
                Product product = new Product(pid,name,category,shop,image,price,decription,details);
                listP.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listP;
    }

    @Override
    public Product newPro() {
        Product product = null;
        try {
            Statement statement = BaseRespository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from product order by id desc limit 0,1;");
            if (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int category_id = resultSet.getInt("category_id");
                int shop_id = resultSet.getInt("shop_id");
                String image = resultSet.getString("image");
                String price = resultSet.getString("price");
                String description = resultSet.getString("description");
                String details = resultSet.getString("details");
                int quantity = resultSet.getInt("quantity");
                Category category = new Category(category_id, null);
                Shop shop = new Shop(shop_id,null,null,null,null);
                product = new Product(id,name,null,category,shop,image,price,description,details,quantity);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public int numAll() {
        int resuft = 0;
        try {
            Statement statement = BaseRespository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select count(id) as num from product;");
            if(resultSet.next()){
                resuft = resultSet.getInt("num");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resuft;
    }

    @Override
    public ArrayList<Product> search(String search) {
        ArrayList<Product> listP = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "select product.id , name, category_id, shop_id, image, price, description, details , shop_name , category_name\n" +
                            "from product \n" +
                            "inner join category\n" +
                            "on product.category_id = category.id\n" +
                            "inner join shop\n" +
                            "on product.shop_id = shop.id\n" +
                            "where product.name like ?;");
            preparedStatement.setString(1,'%' + search + '%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int pid = resultSet.getInt("product.id");
                String name = resultSet.getString("name");
                Category category = new Category(resultSet.getInt("category_id"),resultSet.getString("category_name"));
                Shop shop = new Shop(resultSet.getInt("shop_id"), null, resultSet.getString("shop_name"),null);
                String image = resultSet.getString("image");
                String price = resultSet.getString("price");
                String decription = resultSet.getString("description");
                String details = resultSet.getString("details");
                Product product = new Product(pid,name,category,shop,image,price,decription,details);
                listP.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listP;
    }

    @Override
    public ArrayList<Product> productList(int offset) {
        ArrayList<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "select product.id , name, category_id, shop_id, image, price, description, details , shop_name , category_name\n" +
                            "from product \n" +
                            "inner join category\n" +
                            "on product.category_id = category.id\n" +
                            "inner join shop\n" +
                            "on product.shop_id = shop.id\n" +
                            "LIMIT ?, ?;");
            preparedStatement.setInt(1, offset);
            preparedStatement.setInt(2, DefineUtil.NUMBER_PER_PAGE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("product.id");
                String name = resultSet.getString("name");
                Category category = new Category(resultSet.getInt("category_id"),resultSet.getString("category_name"));
                Shop shop = new Shop(resultSet.getInt("shop_id"), null, resultSet.getString("shop_name"),null);
                String image = resultSet.getString("image");
                String price = resultSet.getString("price");
                String decription = resultSet.getString("description");
                String details = resultSet.getString("details");
                Product product = new Product(id,name,category,shop,image,price,decription,details);
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }


}

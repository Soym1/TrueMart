package MVC.respository.impl;

import MVC.model.*;
import MVC.respository.ImpRepository;
import org.omg.CORBA.INTERNAL;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseRepository implements ImpRepository {
//    private static String jdbcURL = "jdbc:mysql://y5svr1t2r5xudqeq.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/zujjqd9uvilcxk66";
    private static String jdbcURL = "jdbc:mysql://localhost:3306/truemart";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "3951320";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }


    Connection cnn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product INNER JOIN category ON product.category_id = category.id";
        try {
            cnn = new BaseRepository().getConnection();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        new Category(rs.getInt(4), rs.getString(12)),
                        new Shop(rs.getInt(5)),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10)
                ));
            }
        } catch (Exception e) {

        }
        return list;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from category";
        try {
            cnn = new BaseRepository().getConnection();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Category(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
        } catch (Exception e) {

        }
        return list;
    }

    @Override
    public Product findID(int id) {
        BaseRepository listP = new BaseRepository();
        List<Product> list = listP.getAllProduct();
        for (Product p : list) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Product> SearchProductByName(String textSearch) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product INNER JOIN category ON product.category_id = category.id WHERE name like ?";
        try {
            cnn = new BaseRepository().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, "%" + textSearch + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        new Category(rs.getInt(4), rs.getString(12)),
                        new Shop(rs.getInt(5)),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10)
                ));
            }
        } catch (Exception e) {

        }
        return list;
    }

    @Override
    public List<Product> getProductByCategoryID(String CID) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product INNER JOIN category ON product.category_id = category.id" + "where category_id = ?";
        try {
            cnn = new BaseRepository().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, CID);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        new Category(rs.getInt(4), rs.getString(12)),
                        new Shop(rs.getInt(5)),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10)
                ));
            }
        } catch (Exception e) {

        }

        return list;
    }

    @Override
    public List<Product> getProductByCategory(String type, String categoryName) {
        System.out.println("getProdct:"+type);
        String query = null;
        List<Product> list = new ArrayList<>();
        cnn = new BaseRepository().getConnection();
        try {
            switch (type) {
                case "new":
                    query = "SELECT * FROM product INNER JOIN category ON product.category_id = category.id " +
                            "WHERE category_name = ? ORDER BY product.id DESC LIMIT 10 OFFSET 0;";
                    ps = cnn.prepareStatement(query);
                    ps.setString(1, categoryName);
                    break;
                case "top-selling":
                    query = "SELECT * FROM product INNER JOIN category ON product.category_id = category.id " +
                            "WHERE category_name = ? ORDER BY product.id ASC LIMIT 10 OFFSET 0;";
                    ps = cnn.prepareStatement(query);
                    ps.setString(1, categoryName);
                    break;
                case "suggestion":
                    query = "SELECT * FROM product INNER JOIN category ON product.category_id = category.id" +
                            " ORDER BY RAND() LIMIT 20";
                    ps = cnn.prepareStatement(query);
                    break;
                default:
                    if (categoryName != null) {
                        query = "SELECT * FROM product INNER JOIN category ON product.category_id = category.id " +
                                "WHERE category.category_name = ? LIMIT 20;";
                        ps = cnn.prepareStatement(query);
                        ps.setString(1, categoryName);

                    } else {
                        query = "SELECT * FROM product INNER JOIN category ON product.category_id = category.id LIMIT 20";
                        ps = cnn.prepareStatement(query);
                    }
                    break;
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        new Category(rs.getInt(4), rs.getString(12)),
                        new Shop(rs.getInt(5)),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10)
                ));
            }
        } catch (Exception e) {
        }
        System.out.println(list.size());
        return list;
    }

    @Override
    public Product getProductById(Integer productId) {
        Product product = null;
        cnn = getConnection();
        String GET_PRODUCT_NAME_BY_ID = "SELECT * FROM (product INNER JOIN shop ON shop.id = product.shop_id) " +
                "INNER JOIN category ON product.category_id = category.id WHERE product.id = ?";
        try {
            PreparedStatement preparedStatement = cnn.prepareStatement(GET_PRODUCT_NAME_BY_ID);
            preparedStatement.setInt(1, productId);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        new Category(rs.getInt("category_id"), "category_name"),
                        new Shop(rs.getInt("shop_id"), null, rs.getString("shop_name"), rs.getString("address")),
                        rs.getString("image"),
                        rs.getString("price"),
                        rs.getString("description"),
                        rs.getString("details"),
                        rs.getInt("quantity"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public Map<List<Product>, Integer> getProductBySearch(String type, String[] listCategory, double minPrice, double maxPrice, int page, int amount) {
        List<Product> list = new ArrayList<>();
        cnn = new BaseRepository().getConnection();
        String query = "SELECT * FROM product INNER JOIN category ON product.category_id = category.id WHERE " +
                "category.category_name like '%%'";
        String TOTAL_RECORDS = "SELECT count(*) FROM product INNER JOIN category ON product.category_id = category.id WHERE " +
                "category.category_name like '%%'";
        String subquery = "";
        int lastPage = 0;
        Map<List<Product>,Integer> result = new HashMap<>();

        for (int i = 0; i < listCategory.length; i++) {
            if (listCategory[i] != "") {
                if ((subquery == "")) {
                    subquery += "category.category_name like '%" + listCategory[i] + "%'";
                } else {
                    subquery += " OR category.category_name like '%" + listCategory[i] + "%'";
                }
            }
        }
        if (subquery != "") {
            TOTAL_RECORDS += "AND " + subquery;
            query += "AND " + subquery;
        }
        query += "AND CAST(REPLACE(price, '.', '') AS DECIMAL(65,2)) >= ? AND CAST(REPLACE(price, '.', '') AS DECIMAL(65,2)) <= ? LIMIT ? OFFSET ? ;";
        TOTAL_RECORDS += "AND CAST(REPLACE(price, '.', '') AS DECIMAL(65,2)) >= ? AND CAST(REPLACE(price, '.', '') AS DECIMAL(65,2)) <= ?;";
        try {
            ps = cnn.prepareStatement(query);
            ps.setDouble(1, minPrice);
            ps.setDouble(2, maxPrice);
            ps.setInt(3,amount);
            ps.setInt(4, (page - 1) * amount);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        new Category(rs.getInt(4), rs.getString(12)),
                        new Shop(rs.getInt(5)),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10)
                ));
            }
            ps = cnn.prepareStatement(TOTAL_RECORDS);
            ps.setDouble(1,minPrice);
            ps.setDouble(2,maxPrice);
            rs = ps.executeQuery();
            System.out.println(ps);
            while (rs.next()){
                System.out.println(rs.getInt(1));
                result.put(list,rs.getInt(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result ;
    }
}

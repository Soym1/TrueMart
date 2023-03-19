package MVC.respository.impl;

import MVC.model.*;
import MVC.respository.ImpRespository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseRespository implements ImpRespository {
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

//    public static void main(String[] args) {
//        try {
//            System.out.println(new BaseResponsity().getConnection());
//            System.out.println("Connect Sucessful");
//        } catch (Exception e) {
//
//        }
//    }


    Connection cnn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
@Override
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM truemart.product INNER JOIN category ON product.category_id = category.id";
        try {
            cnn = new BaseRespository().getConnection();
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
    public List<Category> getAllCategory()
    {
        List<Category> list = new ArrayList<>();
        String query = "select * from category";
        try {
            cnn = new BaseRespository().getConnection();
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
        BaseRespository listP = new BaseRespository();
        List<Product> list = listP.getAllProduct();
        for (Product p : list) {
            if(p.getId() == id)
            {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Product> SearchProductByName(String textSearch)
    {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM truemart.product INNER JOIN category ON product.category_id = category.id WHERE name like ?";
        try {
            cnn = new BaseRespository().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1,"%" + textSearch + "%");
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
    public List<Product> getProductByCategoryID(String CID)
    {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM truemart.product INNER JOIN category ON product.category_id = category.id" + "where category_id = ?";
        try {
            cnn = new BaseRespository().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1,CID);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        new Category(rs.getInt(4),rs.getString(12)),
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
  public List<Review> GetAllReview()
   {
       List<Review> list = new ArrayList<>();
       String query = "SELECT * FROM review";
       try{
           cnn = new BaseRespository().getConnection();
           ps = cnn.prepareStatement(query);
           rs = ps.executeQuery();
           while (rs.next()) {
               list.add(new Review(
                       rs.getInt(1),
                       rs.getString(2),
                       new Product(rs.getInt(3)),
                       rs.getString(4),
                       rs.getFloat(5)
               ));
           }
       }catch (Exception e)
       {}
       return list;
   }

    @Override
    public List<Product> getProductByCategory(String type,String categoryName) {
        String query=null;
        List<Product> list = new ArrayList<>();
        cnn = new BaseRespository().getConnection();
        try {
        switch (type){
            case "new":
                query = "SELECT * FROM truemart.product INNER JOIN category ON product.category_id = category.id " +
                        "WHERE category_name = ? ORDER BY product.id DESC LIMIT 10 OFFSET 0;";
                ps = cnn.prepareStatement(query);
                ps.setString(1,categoryName);
                break;
            case "top-selling":
                query = "SELECT * FROM truemart.product INNER JOIN category ON product.category_id = category.id " +
                        "WHERE category_name = ? ORDER BY product.id ASC LIMIT 10 OFFSET 0;";
                ps = cnn.prepareStatement(query);
                ps.setString(1,categoryName);
                break;
            case "suggestion":
                query = "SELECT * FROM truemart.product INNER JOIN category ON product.category_id = category.id" +
                        " ORDER BY RAND() LIMIT 20";
                ps = cnn.prepareStatement(query);
                break;
            default:
                if (categoryName != null){
                    query = "SELECT * FROM truemart.product INNER JOIN category ON product.category_id = category.id " +
                            "WHERE category.category_name = ? LIMIT 30;";
                    ps = cnn.prepareStatement(query);
                    ps.setString(1,categoryName);

                }else{
                    query = "SELECT * FROM truemart.product INNER JOIN category ON product.category_id = category.id LIMIT 30";
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
    public List<Product> GetProductbyID(String ID)
    {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product\n" + "where id = ?";
        try {
            cnn = new BaseRespository().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1,ID);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        new Category(rs.getInt("category_id"),null),
                        new Shop(rs.getInt("shop_id"),null,null,null),
                        rs.getString("image"),
                        rs.getString("price"),
                        rs.getString("description"),
                        rs.getString("details"),
                        rs.getInt("quantity")
                ));
            }
        } catch (Exception e) {

        }
        return list;
    }
    @Override
    public List<Cart> GetCartProducts(List<Cart> CartList) {
        List<Cart> Cart_List = new ArrayList<>();

        if (CartList.size() > 0) {
            for (Cart item : CartList) {
                String query = "SELECT * FROM product\n" + "where id = ?";
                try {
                    cnn = new BaseRespository().getConnection();
                    ps = cnn.prepareStatement(query);
                    ps.setInt(1,item.getId());
                    rs = ps.executeQuery();
                    while (rs.next())
                    {
                        Cart cart = new Cart();
                        cart.setId(rs.getInt("id"));
                        cart.setImage(rs.getString("image"));
                        cart.setName(rs.getString("name"));
                        cart.setPrice(rs.getString("price"));
                        cart.setQuantityProduct(item.getQuantityProduct());
                        cart.setTotalMoney(rs.getDouble("price")* item.getQuantityProduct());
                        Cart_List.add(cart);
                    }
                }catch (Exception e)
                {

                }
            }
        }
        return Cart_List;
    }
    @Override
    public double GetTotalCartPrice(List<Cart> CartList) {
        double sum = 0 ;
        if (CartList.size() > 0) {
            for (Cart item : CartList) {
                String query = "SELECT * FROM product\n" + "where id = ?";
                try {
                    cnn = new BaseRespository().getConnection();
                    ps = cnn.prepareStatement(query);
                    ps.setInt(1,item.getId());
                    rs = ps.executeQuery();
                    while (rs.next())
                    {
                        sum += rs.getDouble("price")*item.getQuantityProduct();
                    }
                }catch (Exception e)
                {

                }
            }
        }
        return sum;
    }
    @Override
    public Product getProductById(Integer productId) {
        Product product = null;
        cnn = getConnection();
        String GET_PRODUCT_NAME_BY_ID = "SELECT * FROM (product INNER JOIN shop ON shop.id = product.shop_id) " +
                "INNER JOIN category ON product.category_id = category.id WHERE product.id = ?";
        try {
            PreparedStatement preparedStatement = cnn.prepareStatement(GET_PRODUCT_NAME_BY_ID);
            preparedStatement.setInt(1,productId);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        new Category(rs.getInt("category_id"),"category_name"),
                        new Shop(rs.getInt("shop_id"),null,rs.getString("shop_name"),rs.getString("address")),
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
    public List<Product> getProductBySearch(String type, String[] listCategory, double minPrice, double maxPrice, int page) {
        System.out.println(type+" "+minPrice+maxPrice);
        String query = null;
        List<Product> list = new ArrayList<>();
        cnn = new BaseRespository().getConnection();
        query = "SELECT * FROM truemart.product INNER JOIN category ON product.category_id = category.id WHERE " +
                "category.category_name like '%%'";
        String subquery = "";
        for (int i=0; i < listCategory.length;i++){
            if (listCategory[i] != ""){
                if ((subquery == "")) {
                    subquery += "category.category_name like '%" + listCategory[i] + "%'";
                } else {
                    subquery += " OR category.category_name like '%" + listCategory[i] + "%'";
                }
            }
        }
        System.out.println(subquery);
        if (subquery != ""){
            query += "AND " +  subquery;
        }
        query += "AND CAST(REPLACE(price, '.', '') AS DECIMAL(65,2)) >= ? AND CAST(REPLACE(price, '.', '') AS DECIMAL(65,2)) <= ? LIMIT 30 OFFSET ? ;";
        try {
            ps = cnn.prepareStatement(query);
            ps.setDouble(1,minPrice);
            ps.setDouble(2,maxPrice);
            ps.setInt(3,(page-1) * 30);
            System.out.println(query);
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("listSize: "+list.size());
        return list;
    }
}

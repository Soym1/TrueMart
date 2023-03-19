package MVC.respository.impl;

import MVC.model.Category;
import MVC.model.Product;
import MVC.model.Shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ListProduct {

    Connection cnn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product";
        try {
//            cnn = new com.responsity.impl.BaseResponsive().getConnection();
            ps = cnn.prepareStatement(query);
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

    public static void main(String[] args) {
        ListProduct listP = new ListProduct();
        List<Product> list = listP.getAllProduct();

        for (Product p : list) {
            System.out.println(p);
        }
    }


    public Product findID(int id) {
        ListProduct listP = new ListProduct();
        List<Product> list = listP.getAllProduct();
        for (Product p : list) {
           if(p.getId() == id)
           {
               return p;
           }
        }
        return null;
    }
}

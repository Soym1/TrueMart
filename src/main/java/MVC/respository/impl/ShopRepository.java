package MVC.respository.impl;

import MVC.model.Shop;
import MVC.model.Shopper_Details;
import MVC.model.Users;
import MVC.respository.IShopRepository;
import MVC.util.DefineUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopRepository implements IShopRepository {

    @Override
    public List<Shop> listAll() {
        List<Shop> listShop = new ArrayList<>();
        try {
            Statement statement = BaseRespository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select shop.id, id_users, shop_name, shop.address, username, shopper_details_id, avatar, category  from shop \n" +
                    "inner join users\n" +
                    "on shop.id_users = users.id\n" +
                    "inner join shopper_details\n" +
                    "on shopper_details.id = shop.shopper_details_id;");
            while (resultSet.next()){
                int id = resultSet.getInt("shop.id");
                String name = resultSet.getString("shop_name");
                String address = resultSet.getString("shop.address");
                int id_users = resultSet.getInt("id_users");
                String username = resultSet.getString("username");
                Users users = new Users(id_users,username,null,null,null,null,null,null,null);
                int shopper_details_id = resultSet.getInt(6);
                String img = resultSet.getString(7);
                String category = resultSet.getString(8);
                Shopper_Details shopper_details = new Shopper_Details(shopper_details_id,null,null,null,category,0,null,img);
                Shop shop = new Shop(id,users,name,address,shopper_details);
                listShop.add(shop);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listShop;
    }

    @Override
    public int creat(Shop shop) {
        int reuslt = 0;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "insert into shop(id_users, shop_name, address) values\n" +
                            "(?, ?, ?);"
            );
            preparedStatement.setInt(1, shop.getUsers().getId());
            preparedStatement.setString(2, shop.getShop_name());
            preparedStatement.setString(3, shop.getAddress());
            reuslt = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reuslt;
    }

    @Override
    public Shop find(int id) {
        Shop shop = null;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "select shop.id, id_users, shop_name, shop.address, username from shop \n" +
                            "inner join users\n" +
                            "on shop.id_users = users.id where shop.id = ?;");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String name = resultSet.getString("shop_name");
                String address = resultSet.getString("shop.address");
                int id_users = resultSet.getInt("id_users");
                String username = resultSet.getString("username");
                Users users = new Users(id_users,username,null,null,null,null,null,null,null);
                shop = new Shop(id,users,name,address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shop;
    }

    @Override
    public int edit(Shop shop) {
        int reuslt = 0;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "UPDATE shop\n" +
                            "SET shop_name = ?, address = ?\n" +
                            "WHERE id = ?;"
            );
            preparedStatement.setString(1, shop.getShop_name());
            preparedStatement.setString(2, shop.getAddress());
            preparedStatement.setInt(3, shop.getId());
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
                    "DELETE FROM shop WHERE id = ?;"
            );
            preparedStatement.setInt(1,id);
            reuslt = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reuslt;
    }

    @Override
    public Shop getShop(int id) {
        Shop shop = null;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "select shop.id, id_users, shop_name, shop.address, username, shopper_details_id, shopper_details.email, shopper_details.phonenumber, shopper_details.address, category, quantity, date_created, avatar from shop\n" +
                            "inner join users\n" +
                            "on shop.id_users = users.id\n" +
                            "inner join shopper_details\n" +
                            "on shopper_details.id = shop.shopper_details_id\n" +
                            "where shop.id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int id_shop = resultSet.getInt("shop.id");
                String name = resultSet.getString("shop_name");
                String address = resultSet.getString("shop.address");
                int id_users = resultSet.getInt("id_users");
                String username = resultSet.getString("username");
                Users users = new Users(id_users,username,null,null,null,null,null,null,null);
                Shopper_Details shopper_details = new Shopper_Details(resultSet.getInt(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),resultSet.getInt(11),resultSet.getDate(12),resultSet.getString(13));
                shop = new Shop(id_shop,users,name,address,shopper_details);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shop;
    }

    @Override
    public Shop getShopAll(int id) {
        Shop shop = null;
        System.out.println("id ne"+ id);
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "select shop.id, id_users, shop_name, shop.address, username, shopper_details_id, shopper_details.email, shopper_details.phonenumber, shopper_details.address, category, quantity, date_created, avatar from shop\n" +
                            "inner join users\n" +
                            "on shop.id_users = users.id\n" +
                            "inner join shopper_details\n" +
                            "on shopper_details.id = shop.shopper_details_id\n" +
                            "where shop.id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int id_shop = resultSet.getInt("shop.id");
                System.out.println("id_shop"+id_shop);
                String name = resultSet.getString("shop_name");
                String address = resultSet.getString("shop.address");
                int id_users = resultSet.getInt("id_users");
                String username = resultSet.getString("username");
                Users users = new Users(id_users,username,null,null,null,null,null,null,null);
                Shopper_Details shopper_details = new Shopper_Details(resultSet.getInt(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),resultSet.getInt(11),resultSet.getDate(12),resultSet.getString(13));
                shop = new Shop(id_shop,users,name,address,shopper_details);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shop;
    }

    @Override
    public int addshopdetal(Shopper_Details shopper_details) {
        int result = 0;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "insert into shopper_details(email,phonenumber,address,category,quantity,date_created,avatar) values" +
                            "(?,?,?,?,?,?,?);");
            System.out.println(shopper_details.getEmail() + shopper_details.getPhonenumber() + shopper_details.getAddress() + shopper_details.getCategory()+shopper_details.getQuantity() + shopper_details.getDate_created() + shopper_details.getAvatar() );
            preparedStatement.setString(1,shopper_details.getEmail());
            preparedStatement.setString(2,shopper_details.getPhonenumber());
            preparedStatement.setString(3,shopper_details.getAddress());
            preparedStatement.setString(4,shopper_details.getCategory());
            preparedStatement.setInt(5,shopper_details.getQuantity());
            preparedStatement.setDate(6, (Date) shopper_details.getDate_created());
            preparedStatement.setString(7,shopper_details.getAvatar());
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public Shopper_Details getShopdetails() {
        Shopper_Details shopper_details = null;
        try {
            Statement statement = BaseRespository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from shopper_details order by id desc limit 0,1;");
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                String email = resultSet.getString(2);
                String phone = resultSet.getString(3);
                String address = resultSet.getString(4);
                String category = resultSet.getString(5);
                int quantity = resultSet.getInt(6);
                Date Date = resultSet.getDate(7);
                String avatar = resultSet.getString(8);
                shopper_details = new Shopper_Details(id,email,phone,address,category,quantity,Date,avatar);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shopper_details;
    }

    @Override
    public void addshop(Shop shop) {
        int result = 0;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "insert into shop(id_users,shop_name,shopper_details_id, address) values\n" +
                            "(?,?,?,?)");
            preparedStatement.setInt(1,shop.getUsers().getId());
            preparedStatement.setString(2,shop.getShop_name());
            preparedStatement.setInt(3,shop.getShopper_details().getId());
            preparedStatement.setString(4,shop.getAddress());
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Shop getShopU(int id) {
        Shop shop = null;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "select shop.id, id_users, shop_name, shop.address, username, shopper_details_id, shopper_details.email, shopper_details.phonenumber, shopper_details.address, category, quantity, date_created, avatar from shop\n" +
                            "inner join users\n" +
                            "on shop.id_users = users.id\n" +
                            "inner join shopper_details\n" +
                            "on shopper_details.id = shop.shopper_details_id\n" +
                            "where users.id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int id_shop = resultSet.getInt("shop.id");
                String name = resultSet.getString("shop_name");
                String address = resultSet.getString("shop.address");
                int id_users = resultSet.getInt("id_users");
                String username = resultSet.getString("username");
                Users users = new Users(id_users,username,null,null,null,null,null,null,null);
                Shopper_Details shopper_details = new Shopper_Details(resultSet.getInt(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),resultSet.getInt(11),resultSet.getDate(12),resultSet.getString(13));
                shop = new Shop(id_shop,users,name,address,shopper_details);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shop;
    }

    @Override
    public int countItems() {
        int a = 0;
        try {
            Statement statement = BaseRespository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT COUNT(id) as tong FROM shop");
            if(resultSet.next()){
                a = resultSet.getInt("tong");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return a;
    }

    @Override
    public List<Shop> listAll(int offset) {
        List<Shop> listShop = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "select shop.id, id_users, shop_name, shop.address, username, shopper_details_id, avatar, category  from shop \n" +
                            "inner join users\n" +
                            "on shop.id_users = users.id\n" +
                            "inner join shopper_details\n" +
                            "on shopper_details.id = shop.shopper_details_id\n" +
                            "LIMIT ?, ?;");
            preparedStatement.setInt(1, offset);
            preparedStatement.setInt(2, DefineUtil.NUMBER_PER_PAGE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("shop.id");
                String name = resultSet.getString("shop_name");
                String address = resultSet.getString("shop.address");
                int id_users = resultSet.getInt("id_users");
                String username = resultSet.getString("username");
                Users users = new Users(id_users,username,null,null,null,null,null,null,null);
                int shopper_details_id = resultSet.getInt(6);
                String img = resultSet.getString(7);
                String category = resultSet.getString(8);
                Shopper_Details shopper_details = new Shopper_Details(shopper_details_id,null,null,null,category,0,null,img);
                Shop shop = new Shop(id,users,name,address,shopper_details);
                listShop.add(shop);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listShop;
    }
}

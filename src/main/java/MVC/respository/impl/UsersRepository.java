package MVC.respository.impl;

import MVC.model.Users;
import MVC.respository.IUsersRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersRepository implements IUsersRepository {

    @Override
    public List<Users> findAll() {
        List<Users> usersList = new ArrayList<>();
        try {
            Statement statement = BaseRespository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String phonenumber = resultSet.getString("phonenumber");
                String address = resultSet.getString("address");
                Users users = new Users(id,username,password,role,firstname,lastname,email,phonenumber,address);
                usersList.add(users);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usersList;
    }

    @Override
    public int creat(Users users) {
        int reuslt = 0;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "insert into users(username, password, role, firstname, lastname , email, phonenumber, address) values\n" +
                            "(?, ?, ?, ?, ?, ?, ?, ?)"
            );
            preparedStatement.setString(1, users.getUsername());
            preparedStatement.setString(2, users.getPassword());
            preparedStatement.setString(3, users.getRole());
            preparedStatement.setString(4, users.getFirstname());
            preparedStatement.setString(5, users.getLastname());
            preparedStatement.setString(6, users.getEmail());
            preparedStatement.setString(7, users.getPhonenumber());
            preparedStatement.setString(8, users.getAddress());
            reuslt = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reuslt;
    }

    @Override
    public Users findAll(int id) {
        Users users = null;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "select * from users where id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String phonenumber = resultSet.getString("phonenumber");
                String address = resultSet.getString("address");
                users = new Users(id,username,password,role,firstname,lastname,email,phonenumber,address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public int edit(Users users) {
        int reuslt = 0;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "UPDATE users\n" +
                            "SET password = ?, firstname = ?, lastname = ?, email = ?, phonenumber = ?, address = ?\n" +
                            "WHERE id = ?;"
            );
            preparedStatement.setString(1, users.getPassword());
            preparedStatement.setString(2, users.getFirstname());
            preparedStatement.setString(3, users.getLastname());
            preparedStatement.setString(4, users.getEmail());
            preparedStatement.setString(5, users.getPhonenumber());
            preparedStatement.setString(6, users.getAddress());
            preparedStatement.setInt(7,users.getId());
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
                    "DELETE FROM users WHERE id = ?;"
            );
            preparedStatement.setInt(1,id);
            reuslt = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reuslt;
    }

    @Override
    public List<Users> listUserNS() {
        List<Users> listUserNS = new ArrayList<>();
        try {
            Statement statement = BaseRespository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select  users.id, username from shop \n" +
                    "right join users\n" +
                    "on shop.id_users = users.id where shop.id is null && role = \"Producter\";\n");
            while (resultSet.next()){
                int id = resultSet.getInt("users.id");
                String username = resultSet.getString("username");
                Users users = new Users(id,username,null,null,null,null,null,null,null);
                listUserNS.add(users);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listUserNS;
    }

    @Override
    public Users kiemtra(String username, String password) {
        Users users = null;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "select * from users where username = ? AND password = ?;");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int id = resultSet.getInt("id");
                String role = resultSet.getString("role");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String phonenumber = resultSet.getString("phonenumber");
                String address = resultSet.getString("address");
                users = new Users(id,username,password,role,firstname,lastname,email,phonenumber,address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public int numAll() {
        int resuft = 0;
        try {
            Statement statement = BaseRespository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select count(id) as num from users;");
            if(resultSet.next()){
                resuft = resultSet.getInt("num");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resuft;
    }


}

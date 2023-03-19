package MVC.respository.impl;

import MVC.model.Messages;
import MVC.model.User;
import MVC.respository.ImplBaseRespositoryChat;
import com.mysql.cj.Session;
import org.json.simple.JSONObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseRespositoryChat implements ImplBaseRespositoryChat {
    private static Connection connection;
    private static Session session;
    private static String username;

    private static String GET_SESSION = "SELECT session_id FROM user_account";
    private static String GET_USER = "SELECT * FROM users WHERE username = ?";
    private static String GET_MESSAGE = "SELECT * FROM message WHERE sender_id = ? OR receiver_id = ? ORDER BY submit_date ASC";
    private static String GET_MESSAGE_2 = "SELECT * FROM message WHERE (sender_id = ? AND receiver_id = ?) OR " +
            "(sender_id = ? AND receiver_id = ?)  ORDER BY submit_date ASC";
    private static String GET_NAME_BY_ID = "SELECT username FROM users WHERE id = ?";
    private static String GET_LIST_CONTACT = "SELECT DISTINCT sender_id FROM " +
            "(((SELECT sender_id,submit_date FROM message WHERE receiver_id = ?) " +
            "UNION" +
            " (SELECT receiver_id,submit_date FROM message WHERE sender_id = ?)) ORDER BY submit_date) as danh_sach";
    private static String GET_ID_BY_NAME = "SELECT id FROM users WHERE username = ?";
    private static String INSERT_MESSAGE = "INSERT INTO message(sender_id,receiver_id,message,submit_date) VALUES (?,?,?,?)";
    private static String GET_LIST_SEARCH = "SELECT id FROM users WHERE username LIKE ?";


    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public void setSession(Session session) {

    }

    @Override
    public void setUserName(String username) {

    }

    @Override
    public User getUser (String username) {
        connection = BaseRespository.getConnection();
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int user_id = resultSet.getInt("id");
                String userName = resultSet.getString("username");
                String passWord = resultSet.getString("password");
                String role = resultSet.getString("role");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phonenumber");
                String address = resultSet.getString("address");
                user = new User(user_id,userName,passWord,role,firstName,lastName,email,phoneNumber,address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<Messages> getMessage(String username) {
        List<Messages> messagesList = new ArrayList<>();
        User user = new BaseRespositoryChat().getUser(username);
        connection = BaseRespository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MESSAGE);
            preparedStatement.setInt(1,user.getUser_id());
            preparedStatement.setInt(2,user.getUser_id());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                messagesList.add(new Messages(resultSet.getInt("id"),
                        resultSet.getInt("sender_id"),
                        resultSet.getInt("receiver_id"),
                        resultSet.getString("message"),
                        resultSet.getDate("submit_date")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return messagesList;
    }

    @Override
    public void saveMessage(JSONObject message) {
        System.out.println("save Message");
        System.out.println(message);
        connection = BaseRespository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MESSAGE);
            preparedStatement.setInt(1,Integer.parseInt(message.get("sender_id").toString()));
            preparedStatement.setInt(2,Integer.parseInt(message.get("receiver_id").toString()));
            preparedStatement.setString(3,message.get("message").toString());
            preparedStatement.setString(4,message.get("submit_date").toString());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Messages> getMessage_2(int sender_id, int receiver_id) {
        List<Messages> messagesList = new ArrayList<>();
        connection = BaseRespository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MESSAGE_2);
            preparedStatement.setInt(1,sender_id);
            preparedStatement.setInt(2,receiver_id);
            preparedStatement.setInt(3,receiver_id);
            preparedStatement.setInt(4,sender_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                messagesList.add(new Messages(resultSet.getInt("id"),
                        resultSet.getInt("sender_id"),
                        resultSet.getInt("receiver_id"),
                        resultSet.getNString("message"),
                        resultSet.getDate("submit_date")));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return messagesList;
    }

    @Override
    public List<String> getListContact(String id) {
        connection = BaseRespository.getConnection();
        List<String> senderList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_LIST_CONTACT);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                senderList.add(resultSet.getString("sender_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return senderList;
    }

    @Override
    public String getNameById(String id) {
        connection = BaseRespository.getConnection();
        String name = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_NAME_BY_ID);
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                name = resultSet.getString("username");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return name;
    }

    @Override
    public String getIdByName(String username) {
        connection = BaseRespository.getConnection();
        String id = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ID_BY_NAME);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getString("id");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return id ;
    }

    @Override
    public List<String> getListSearch(String search) {
        connection = BaseRespository.getConnection();
        List<String> listID = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_LIST_SEARCH);
            preparedStatement.setString(1,"%"+search+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                listID.add(resultSet.getString("id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listID;
    }
}
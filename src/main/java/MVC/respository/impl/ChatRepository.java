package MVC.respository.impl;

import MVC.model.Conversation;
import MVC.model.Messages;
import MVC.model.User;
import MVC.respository.ImplChatRepository;
import MVC.service.Impl.ServiceChat;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mysql.cj.Session;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChatRepository implements ImplChatRepository {
    private static Connection connection;
    private static String GET_SESSION = "SELECT session_id FROM user_account";
    private static String GET_USER = "SELECT * FROM users WHERE username = ?";
    private static String GET_MESSAGE = "SELECT * FROM messages WHERE sender_id = ? OR receiver_id = ? ORDER BY date_send ASC";
    private static String GET_MESSAGE_2 = "SELECT * FROM messages WHERE messages.conversation = ? ORDER BY date_send DESC LIMIT ?;";
    private static String GET_USERNAME_BY_ID = "SELECT username FROM users WHERE id = ?";
    private static String GET_LIST_CONTACT = "SELECT DISTINCT * FROM (SELECT conversation.user_id FROM conversation INNER JOIN messages ON messages.conversation = conversation.conversation WHERE conversation.conversation IN (SELECT conversation FROM conversation WHERE user_id = ?) AND user_id != ? \n" +
            "ORDER BY date_send) as user_id_table;";
    private static String GET_ID_BY_NAME = "SELECT id FROM users WHERE username = ?";
    private static String GET_LIST_SEARCH = "SELECT users.id,username,firstname,lastname,shop_name FROM users LEFT JOIN (shop LEFT JOIN shopper_details ON shopper_details.id = shop.shopper_details_id) ON shop.id_users = users.id\n" +
            "WHERE username like ? or firstname like ? or lastname like ? or shop_name like ? ; ";
    private static String GET_NAME_BY_ID = "SELECT firstname,lastname FROM users WHERE id = ?";
    private static String GET_SHOPNAME_BY_ID = "SELECT shop_name FROM users LEFT JOIN (shop LEFT JOIN shopper_details ON shopper_details.id = shop.shopper_details_id) ON shop.id_users = users.id\n" +
            "WHERE users.id = ?";

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
        connection = BaseRepository.getConnection();
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
//        List<Messages> messagesList = new ArrayList<>();
//        User user = new ChatRepository().getUser(username);
//        connection = BaseRepository.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(GET_MESSAGE);
//            preparedStatement.setInt(1,user.getUser_id());
//            preparedStatement.setInt(2,user.getUser_id());
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                messagesList.add(new Messages(resultSet.getInt("id"),
//                        resultSet.getInt("sender_id"),
//                        resultSet.getInt("receiver_id"),
//                        resultSet.getString("message"),
//                        resultSet.getDate("date_send")));
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return messagesList;
        return null;
    }

    @Override
    public void saveMessage(JsonObject message) {
        connection = BaseRepository.getConnection();
        int userId = Integer.parseInt(new ChatRepository().getIdByName(message.get("username").toString()));
        int receiverId = message.get("receiver").getAsInt();
        List<Integer> listID = new ArrayList<>();
        listID.add(userId);
        listID.add(receiverId);
        int conversation = getConversation(listID);
        JsonArray data = message.getAsJsonArray("data");
        String INSERT_MESSAGES = "";
        String VALUES = "";
        for (int i = 0; i < data.size(); i++){
            if (VALUES != ""){VALUES += ",";}
            String type = data.get(i).getAsJsonObject().get("type_mess").getAsString();
            String name_mess = data.get(i).getAsJsonObject().get("name_mess").getAsString();
            String messages = data.get(i).getAsJsonObject().get("messages").getAsString();
            String data_send = message.get("date_send").toString();
            VALUES += "("+userId +","+conversation +",\"" +type +"\",\"" +name_mess +"\",\"" +messages +"\","+ data_send + ")";
        }
        INSERT_MESSAGES += "INSERT INTO messages (sender_id,conversation,type_mess,name_mess,messages,date_send) VALUES "+VALUES+";";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MESSAGES);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Messages> getMessage_2(int senderId, int receiverId, int indexLoadChat) {
        List<Messages> messagesList = new ArrayList<>();
        connection = BaseRepository.getConnection();
        List<Integer> listID = new ArrayList<>();
        listID.add(senderId);
        listID.add(receiverId);
        int conversation = getConversation(listID);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MESSAGE_2);
            preparedStatement.setInt(1,conversation);
            preparedStatement.setInt(2,(indexLoadChat + 1) * 12);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                messagesList.add(new Messages(resultSet.getInt("id"),
                        resultSet.getInt("sender_id"),
                        resultSet.getInt("conversation"),
                        resultSet.getString("type_mess"),
                        resultSet.getString("name_mess"),
                        resultSet.getString("messages"),
                        resultSet.getDate("date_send")));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return messagesList;
    }
    @Override
    public int getMaxChatRecords(int senderId, int receiverId){
        connection = BaseRepository.getConnection();
        int maxChatRecords = 0;
        List<Integer> listID = new ArrayList<>();
        listID.add(senderId);
        listID.add(receiverId);
        int conversation = getConversation(listID);
        String GET_MAX_CHAT_RECORDS = "SELECT COUNT(*) FROM messages WHERE messages.conversation = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MAX_CHAT_RECORDS);
            preparedStatement.setInt(1,conversation);
            System.out.println("max: " + preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                maxChatRecords =  resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return maxChatRecords;
    }
    @Override
    public List<Integer> getListContact(int id) {
        connection = BaseRepository.getConnection();
        List<Integer> senderList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_LIST_CONTACT);
            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2,id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                senderList.add(resultSet.getInt("user_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return senderList;
    }

    @Override
    public String getUserNameByID(int id) {
        connection = BaseRepository.getConnection();
        String username = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USERNAME_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                username = resultSet.getString("username");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return username;
    }
    @Override
    public String getNameByID(int ID) {
        connection = BaseRepository.getConnection();
        String name = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_NAME_BY_ID);
            preparedStatement.setInt(1,ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("firstname");
                name = firstName + " " +lastName;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return name;
    }
    @Override
    public String getShopNameByID(int ID) {
        connection = BaseRepository.getConnection();
        String shopName = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_SHOPNAME_BY_ID);
            preparedStatement.setInt(1,ID);
            System.out.println(ID);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                if (resultSet.getString("shop_name") != null){
                    shopName = resultSet.getString("shop_name").replace(" ","%20");
                } else {
                    shopName = "";
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shopName;
    }
    @Override
    public String getIdByName(String username) {
        connection = BaseRepository.getConnection();
        String id = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ID_BY_NAME);
            preparedStatement.setString(1,username.replaceAll("\"",""));
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
    public List<Integer> getListSearch(String search) {
        connection = BaseRepository.getConnection();
        System.out.println("chay vao day "+search);
        List<Integer> listID = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_LIST_SEARCH);
            preparedStatement.setString(1,"%"+search+"%");
            preparedStatement.setString(2,"%"+search+"%");
            preparedStatement.setString(3,"%"+search+"%");
            preparedStatement.setString(4,"%"+search+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                listID.add(resultSet.getInt("id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listID;
    }

    public int getConversation(List<Integer> listID) {
        connection = BaseRepository.getConnection();
        int conversationNumber = 0;
        String list = "";
        PreparedStatement preparedStatement;
        for (int i = 0; i < listID.size(); i++){
            if (list != ""){
                list += ", ";
            }
            list += listID.get(i);
        }
        String CHECK_CONVERSATION = "SELECT conversation\n" +
                "FROM conversation\n" +
                "WHERE user_id IN ("+list+")\n" +
                "GROUP BY Conversation\n" +
                "HAVING COUNT(DISTINCT user_id) = "+listID.size()+";";
        try {
            preparedStatement = connection.prepareStatement(CHECK_CONVERSATION);
            System.out.println("check conversattion: "+preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next() != false){
                conversationNumber = resultSet.getInt(1);
            } else {
                String MAX_CONVERSATION = "SELECT MAX(conversation) FROM conversation";
                preparedStatement = connection.prepareStatement(MAX_CONVERSATION);
                System.out.println("check max conversattion: "+preparedStatement);
                ResultSet resultSet_1 = preparedStatement.executeQuery();
                while (resultSet_1.next()){
                    conversationNumber = resultSet_1.getInt(1)+1;
                    String NEW_CONVERSATION = "";
                    String VALUES = "";
                    for (int i = 0; i < listID.size(); i++){
                        if (VALUES != ""){VALUES += ",";}
                        VALUES += "("+conversationNumber +","+ listID.get(i) + ")";
                    }
                    NEW_CONVERSATION += "INSERT INTO conversation (conversation,user_id) VALUES "+VALUES+";";
                    connection.prepareStatement(NEW_CONVERSATION).execute();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conversationNumber;
    }

}
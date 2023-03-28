package MVC.respository;

import MVC.model.Messages;
import MVC.model.User;
import com.google.gson.JsonObject;
import com.mysql.cj.Session;
import org.json.simple.JSONObject;
import java.sql.Connection;
import java.util.List;

public interface ImplChatRepository {
    public Connection getConnection();
    public void setSession(Session session);
    public void setUserName(String username);
    public User getUser(String username);
    public List<Messages> getMessage(String username);
    public String getUserNameByID(int ID);

    int getMaxChatRecords(int senderId, int receiverId);

    public List<Integer> getListContact(int ID);

    String getNameByID(int ID);

    String getShopNameByID(int ID);

    public String getIdByName(String username);
    public List<Messages> getMessage_2(int sender_id,int receiver_id, int indexLoadChat);
    public void saveMessage(JsonObject message);
    public List<Integer> getListSearch(String search);
}
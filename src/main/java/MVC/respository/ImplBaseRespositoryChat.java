package MVC.respository;

import MVC.model.Messages;
import MVC.model.User;
import com.mysql.cj.Session;
import org.json.simple.JSONObject;
import java.sql.Connection;
import java.util.List;

public interface ImplBaseRespositoryChat {
    public Connection getConnection();
    public void setSession(Session session);
    public void setUserName(String username);
    public User getUser(String username);
    public List<Messages> getMessage(String username);
    public String getNameById(String id);
    public List<String> getListContact(String id);
    public String getIdByName(String username);
    public List<Messages> getMessage_2(int sender_id,int receiver_id);
    public void saveMessage(JSONObject message);
    public List<String> getListSearch(String search);
}
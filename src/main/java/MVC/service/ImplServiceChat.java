package MVC.service;

import MVC.model.Messages;
import MVC.model.User;
import com.google.gson.JsonObject;
import org.json.simple.JSONObject;

import java.util.List;

public interface ImplServiceChat {
    int getMaxChatRecords(int sender_id, int receiver_id);

    public void setUserName(String username);
    public User getUser(String username);
    public List<Messages> getMessage(String username);
    public String getUserNameByID(int id);

    List<String> getListNameByID(List<Integer> listID);

    List<String> getListShopNameByID(List<Integer> listID);

    public String getIdByName(String username);

    public String getNameByID(int id);

    public String getShopNameByID(int id);

    public List<Integer> getListContact(int id);
    public List<String> getListUserNameByID(List<Integer> listID);
    public List<Messages> getMessage_2(int sender_id, int receiver_id, int indexLoadChat);
    public void saveMessage(JsonObject message);
    public List<Integer> getListSearch(String search);
}
package MVC.service;

import MVC.model.Messages;
import MVC.model.User;
import org.json.simple.JSONObject;

import java.util.List;

public interface ImplServiceChat {
    public void setUserName(String username);
    public User getUser(String username);
    public List<Messages> getMessage(String username);
    public String getNameById(String id);
    public String getIdByName(String username);
    public List<String> getListContact(String id);
    public List<String> getListSenderByName(List<String> listById);
    public List<Messages> getMessage_2(int sender_id, int receiver_id);
    public void saveMessage(JSONObject message);
    public List<String> getListSearch(String search);
}
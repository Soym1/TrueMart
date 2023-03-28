package MVC.service.Impl;

import MVC.model.Messages;
import MVC.model.User;
import MVC.respository.impl.ChatRepository;
import MVC.service.ImplServiceChat;
import com.google.gson.JsonObject;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ServiceChat implements ImplServiceChat {
    @Override
    public List<Messages> getMessage(String username) {
        return new ChatRepository().getMessage(username);
    }

    @Override
    public void saveMessage(JsonObject message) {
        new ChatRepository().saveMessage(message);
    }

    @Override
    public List<Messages> getMessage_2(int sender_id, int receiver_id, int indexLoadChat) {
        return new ChatRepository().getMessage_2(sender_id,receiver_id, indexLoadChat);
    }
    @Override
    public int getMaxChatRecords(int sender_id, int receiver_id){
        return new ChatRepository().getMaxChatRecords(sender_id,receiver_id);
    }
    @Override
    public void setUserName(String username) {
        new ChatRepository().setUserName(username);
    }

    @Override
    public User getUser(String username) {
        return new ChatRepository().getUser(username);
    }

    @Override
    public String getUserNameByID(int id) {
        return new ChatRepository().getUserNameByID(id);
    }
    @Override
    public String getNameByID(int id) {
        return new ChatRepository().getNameByID(id);
    }
    @Override
    public String getShopNameByID(int id) {
        return new ChatRepository().getShopNameByID(id);
    }
    @Override
    public List<Integer> getListContact(int id) {
        return new ChatRepository().getListContact(id);
    }

    @Override
    public List<String > getListUserNameByID(List<Integer> listID) {
        List<String> listUserName = new ArrayList<>();
        for (int ID : listID) {
            listUserName.add(new ChatRepository().getUserNameByID(ID));
        }
        return listUserName;
    }
    @Override
    public List<String> getListNameByID(List<Integer> listID) {
        List<String> listName = new ArrayList<>();
        for (int ID : listID){
            listName.add(new ChatRepository().getNameByID(ID));
        }
        return listName;
    }
    @Override
    public List<String> getListShopNameByID(List<Integer> listID) {
        List<String> listShopName = new ArrayList<>();
        for (int ID : listID){
            listShopName.add(new ChatRepository().getShopNameByID(ID));
        }
        return listShopName;
    }
    @Override
    public String getIdByName(String username) {
        return new ChatRepository().getIdByName(username);
    }

    @Override
    public List<Integer> getListSearch(String search) {
        return new ChatRepository().getListSearch(search);
    }
}
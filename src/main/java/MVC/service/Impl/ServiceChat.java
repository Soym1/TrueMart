package MVC.service.Impl;

import MVC.model.Messages;
import MVC.model.User;
import MVC.respository.impl.BaseRespositoryChat;
import MVC.service.ImplService;
import MVC.service.ImplServiceChat;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ServiceChat implements ImplServiceChat {
    @Override
    public List<Messages> getMessage(String username) {
        return new BaseRespositoryChat().getMessage(username);
    }

    @Override
    public void saveMessage(JSONObject message) {
        new BaseRespositoryChat().saveMessage(message);
    }

    @Override
    public List<Messages> getMessage_2(int sender_id, int receiver_id) {
        return new BaseRespositoryChat().getMessage_2(sender_id,receiver_id);
    }

    @Override
    public void setUserName(String username) {
        new BaseRespositoryChat().setUserName(username);
    }

    @Override
    public User getUser(String username) {
        return new BaseRespositoryChat().getUser(username);
    }

    @Override
    public String getNameById(String id) {
        return new BaseRespositoryChat().getNameById(id);
    }

    @Override
    public List<String> getListContact(String id) {
        return new BaseRespositoryChat().getListContact(id);
    }

    @Override
    public List<String> getListSenderByName(List<String> listById) {
        List<String> listByName = new ArrayList<>();
        for (String id : listById) {
            listByName.add(new BaseRespositoryChat().getNameById(id));
        }
        return listByName;
    }

    @Override
    public String getIdByName(String username) {
        return new BaseRespositoryChat().getIdByName(username);
    }

    @Override
    public List<String> getListSearch(String search) {
        return new BaseRespositoryChat().getListSearch(search);
    }
}
package MVC.controller;

import MVC.service.Impl.ServiceChat;
import com.google.gson.Gson;

import java.util.Map;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.*;
import javax.servlet.http.HttpServlet;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chatRoomServer")
public class SocketEndPoint extends HttpServlet {
    static Map<String, Session> users = new HashMap<String,Session>();
    //    static Map<user,Session> mapUsers = Collections.synchronizedMap(new HashMap<>());
    @OnOpen
    public void handleOpen(Session session) throws IOException {
        users.put(session.getQueryString(),session);

    }

    @OnMessage
    public void handleMessage(String message, Session userSession) throws IOException, EncodeException {
        JSONObject convertedObject = new Gson().fromJson(message, JSONObject.class);
        String username = convertedObject.get("sender").toString();
        String receiver = convertedObject.get("receiver").toString();
        String sender_id = new ServiceChat().getIdByName(username);
        String receiver_id = new ServiceChat().getIdByName(receiver);
        convertedObject.put("sender_id",sender_id);
        convertedObject.put("receiver_id",receiver_id);
        convertedObject.put("sender_name",new ServiceChat().getNameById(sender_id));
        new ServiceChat().saveMessage(convertedObject);

        if (users.containsKey(receiver)){
            users.get(receiver).getBasicRemote().sendText(convertedObject.toString());
        }

    }
    @OnClose
    public void handleClose(Session session) {
        System.out.println("close");
//        static Map<String,Session> users = new HashMap<String,Session>();
        users.forEach((k,v)->{
            if (String.valueOf(v) == String.valueOf(session)){
                users.remove(k,v);
            }
        });
//        users.remove(session);
    }
    @OnError
    public void handleError(Throwable t) {
        t.printStackTrace();
    }


}
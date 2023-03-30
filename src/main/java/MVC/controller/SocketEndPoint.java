package MVC.controller;

import MVC.service.Impl.ServiceChat;
import com.google.gson.*;

import java.nio.ByteBuffer;
import java.util.Map;


import java.io.IOException;
import java.util.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Part;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
@ServerEndpoint(value = "/chatRoomServer")
public class SocketEndPoint {
    static Map<String, Session> users = new HashMap<String,Session>();
    //    static Map<user,Session> mapUsers = Collections.synchronizedMap(new HashMap<>());
    @OnOpen
    public void handleOpen(Session session) throws IOException {
        System.out.println("co chay vao socket");
        users.put(session.getQueryString(),session);
        session.setMaxBinaryMessageBufferSize(999999999);
        session.setMaxTextMessageBufferSize(9999999);
    }

    @OnMessage
    public void handleMessage(String message, Session userSession) throws IOException, EncodeException {
        System.out.println("Message: " + message );
        JsonObject convertedObject = new Gson().fromJson(message, JsonObject.class);
        new ServiceChat().saveMessage(convertedObject);
        int receiverID = convertedObject.get("receiver").getAsInt();
        String receiver = new ServiceChat().getUserNameByID(receiverID);
        String username = convertedObject.get("username").toString();
        String sender_id = new ServiceChat().getIdByName(username);
        String sender_name = new ServiceChat().getNameByID(Integer.parseInt(sender_id)).replace(" ","%20");
        String sender_shop_name = new ServiceChat().getShopNameByID(Integer.parseInt(sender_id));
        convertedObject.add("sender_username",new Gson().fromJson(username,JsonElement.class));
        convertedObject.add("sender_id",new Gson().fromJson(sender_id,JsonElement.class));
        convertedObject.add("sender_name",new Gson().fromJson(sender_name,JsonElement.class));
        convertedObject.add("sender_shop_name",new Gson().fromJson(sender_shop_name,JsonElement.class));
        convertedObject.remove("username");
        if (users.containsKey(receiver)){
            users.get(receiver).getBasicRemote().sendText(convertedObject.toString());
        }
    }
    @OnClose
    public void handleClose(Session session) {
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
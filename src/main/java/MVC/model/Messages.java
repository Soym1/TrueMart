package MVC.model;

import java.util.Date;

public class Messages {
    private int id;
    private int sender_id;
    private int conversation;
    private String type_mess;
    private String name_mess;
    private String messages;
    private Date date_send;
    public Messages(int id, int sender_id, int conversation, String type_mess, String name_mess, String messages, Date date_send) {
        this.id = id;
        this.sender_id = sender_id;
        this.conversation = conversation;
        this.type_mess = type_mess;
        this.name_mess = name_mess;
        this.messages = messages;
        this.date_send = date_send;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public int getConversation() {
        return conversation;
    }

    public void setConversation(int conversation) {
        this.conversation = conversation;
    }

    public String getType_mess() {
        return type_mess;
    }

    public void setType_mess(String type_mess) {
        this.type_mess = type_mess;
    }

    public String getName_mess() {
        return name_mess;
    }

    public void setName_mess(String name_mess) {
        this.name_mess = name_mess;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public Date getDate_send() {
        return date_send;
    }

    public void setDate_send(Date date_send) {
        this.date_send = date_send;
    }
}


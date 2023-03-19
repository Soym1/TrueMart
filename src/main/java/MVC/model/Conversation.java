package MVC.model;

import java.util.Date;

public class Conversation {
    private int id_conversations;
    private int sender_id;
    private int receiver_id;

    public Conversation(int id_conversations, int sender_id, int receiver_id) {
        this.id_conversations = id_conversations;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
    }

    public int getId_conversations() {
        return id_conversations;
    }

    public void setId_conversations(int id_conversations) {
        this.id_conversations = id_conversations;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public int getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }
}

package MVC.model;

import java.util.Date;

public class Conversation {
    private int id_conversations;
    private int user_id;

    public Conversation(int id_conversations) {
        this.id_conversations = id_conversations;
    }

    public int getId_conversations() {
        return id_conversations;
    }

    public void setId_conversations(int id_conversations) {
        this.id_conversations = id_conversations;
    }
}

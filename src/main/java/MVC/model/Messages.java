package MVC.model;

import java.util.Date;

public class Messages {
    private int id_message;
    private int sender_id;
    private int receiver_id;
    private String message;
    private Date summit_date;

    public Messages(int id_message, int sender_id, int receiver_id, String message, Date summit_date) {
        this.id_message = id_message;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.message = message;
        this.summit_date = summit_date;
    }

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSummit_date() {
        return summit_date;
    }

    public void setSummit_date(Date summit_date) {
        this.summit_date = summit_date;
    }

    @Override
    public String toString() {
        return "{\"sender\":\"" + sender_id + "\",\"receiver\":\"" + receiver_id + "\",\"message\":\"" + message +"\",\"summit_date\":\"" + summit_date + "\"}";
    }
}


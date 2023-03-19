package MVC.respository;

import MVC.model.Contact;

import java.util.ArrayList;

public interface IContactRepository {
    int add(Contact contact);

    ArrayList<Contact> listAll();

    int del(int id);
}

package MVC.service;

import MVC.model.Contact;

import java.util.ArrayList;

public interface IContactService {
    int add(Contact contact);

    ArrayList<Contact> listAll();

    int del(int id);
}

package MVC.service.Impl;

import MVC.model.Contact;
import MVC.respository.IContactRepository;
import MVC.respository.impl.ContactRepository;
import MVC.service.IContactService;

import java.util.ArrayList;

public class ContactService implements IContactService {
    private IContactRepository iContactRepository = new ContactRepository();

    @Override
    public int add(Contact contact) {
        return iContactRepository.add(contact);
    }

    @Override
    public ArrayList<Contact> listAll() {
        return iContactRepository.listAll();
    }

    @Override
    public int del(int id) {
        return iContactRepository.del(id);
    }
}

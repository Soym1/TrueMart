package MVC.respository.impl;

import MVC.model.Contact;
import MVC.respository.IContactRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ContactRepository implements IContactRepository {
    @Override
    public int add(Contact contact) {
        int result = 0;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "insert into contact(fullname,email,website,subject,content) values\n" +
                            "(?,?,?,?,?);");
            preparedStatement.setString(1,contact.getFullname());
            preparedStatement.setString(2,contact.getEmail());
            preparedStatement.setString(3,contact.getWebsite());
            preparedStatement.setString(4,contact.getSubject());
            preparedStatement.setString(5,contact.getContent());
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Contact> listAll() {
        ArrayList<Contact> listContact = new ArrayList<>();
        try {
            Statement statement = BaseRespository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from contact;");
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String fullname = resultSet.getString(2);
                String email = resultSet.getString(3);
                String website = resultSet.getString(4);
                String subject = resultSet.getString(5);
                String content = resultSet.getString(6);
                Contact contact = new Contact(id,fullname,email,website,subject,content);
                listContact.add(contact);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listContact;
    }

    @Override
    public int del(int id) {
        int reuslt = 0;
        try {
            PreparedStatement preparedStatement = BaseRespository.getConnection().prepareStatement(
                    "DELETE FROM contact WHERE id = ?;"
            );
            preparedStatement.setInt(1,id);
            reuslt = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reuslt;
    }
}

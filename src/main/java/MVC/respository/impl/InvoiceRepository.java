package MVC.respository.impl;

import MVC.respository.ImpInvoiceRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InvoiceRepository implements ImpInvoiceRepository {

    @Override
    public int numAll() {
        int resuft = 0;
        try {
            Statement statement = BaseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select count(id) as num from invoice;");
            if(resultSet.next()){
                resuft = resultSet.getInt("num");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resuft;
    }
}

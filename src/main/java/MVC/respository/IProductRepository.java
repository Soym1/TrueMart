package MVC.respository;

import MVC.model.Product;

import java.util.ArrayList;
import java.util.List;

public interface IProductRepository {
    List<Product> productList();

    int creat(Product product);

    Product findAll(int id);

    int edit(Product product);

    int del(int id);

    ArrayList<Product> productShop(int id);

    Product newPro();

    int numAll();

    ArrayList<Product> search(String search);

    ArrayList<Product> productList(int offset);
}

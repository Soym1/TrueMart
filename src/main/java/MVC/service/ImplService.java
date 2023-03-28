package MVC.service;

import MVC.model.Cart;
import MVC.model.Category;
import MVC.model.Product;
import MVC.model.Review;

import java.util.List;
import java.util.Map;

public interface ImplService {
    public Product findID(int id);
    public List<Product> getAllProduct();
    public List<Product> SearchProductByName(String textSearch);
    public List<Category> getAllCategory();
    public List<Product> getProductByCategoryID(String CID);
    Map<List<Product>, Integer> getProductBySearch(String type, String[] listCategory, double minPrice, double maxPrice, int page, int amount);
    List<Product> getProductByCategory(String type,String parameter);
    Product getProductById(Integer productId);
}

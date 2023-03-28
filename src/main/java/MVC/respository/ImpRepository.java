package MVC.respository;

import MVC.model.Cart;
import MVC.model.Category;
import MVC.model.Product;
import MVC.model.Review;


import java.util.List;
import java.util.Map;

public interface ImpRepository {
    public List<Product> getAllProduct();

    public List<Product> SearchProductByName(String textSearch);

    public Product findID(int id);

    public List<Category> getAllCategory();

    public List<Product> getProductByCategoryID(String CID);


    List<Product> getProductByCategory(String type, String categoryName);

    Product getProductById(Integer productId);

    Map<List<Product>, Integer> getProductBySearch(String type, String[] listCategory, double minPrice, double maxPrice, int page, int amount);
}

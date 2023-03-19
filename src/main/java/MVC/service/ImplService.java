package MVC.service;

import MVC.model.Cart;
import MVC.model.Category;
import MVC.model.Product;
import MVC.model.Review;

import java.util.List;

public interface ImplService {
    public Product findID(int id);
    public List<Product> getAllProduct();
    public List<Product> SearchProductByName(String textSearch);

    public List<Category> getAllCategory();

    public List<Product> getProductByCategoryID(String CID);

    List<Product> getProductBySearch(String type, String[] listCategory, double minPrice, double maxPrice, int page);

    public List<Review> GetAllReview();

    List<Product> getProductByCategory(String type,String parameter);

    List<Cart> GetCartProducts(List<Cart> CartList);

    double GetTotalCartPrice(List<Cart> CartList);

    Product getProductById(Integer productId);
}

package MVC.respository;

import MVC.model.Cart;
import MVC.model.Category;
import MVC.model.Product;
import MVC.model.Review;


import java.util.List;

public interface ImpRespository {
    public List<Product> getAllProduct();

    public List<Product> SearchProductByName(String textSearch);
    public Product findID(int id);
    public List<Category> getAllCategory();

    public List<Product> getProductByCategoryID(String CID);

    public List<Product> GetProductbyID(String ID);
    public List<Review> GetAllReview();

    public List<Cart> GetCartProducts(List<Cart> CartList);
    public double GetTotalCartPrice(List<Cart> CartList);


    List<Product> getProductByCategory(String type, String categoryName);

    Product getProductById(Integer productId);

    List<Product> getProductBySearch(String type, String[] listCategory, double minPrice, double maxPrice, int page);
}

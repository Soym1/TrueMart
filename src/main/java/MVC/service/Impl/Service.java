package MVC.service.Impl;

import MVC.model.Cart;
import MVC.model.Category;
import MVC.model.Product;
import MVC.model.Review;
import MVC.respository.impl.BaseRespository;
import MVC.service.ImplService;

import java.util.List;

public class Service implements ImplService {

    @Override
    public List<Product> getAllProduct()
    {
        return new BaseRespository().getAllProduct();
    }
    @Override
    public Product findID(int id) {
        return new BaseRespository().findID(id);
    }
    @Override
    public List<Category> getAllCategory()
    {
        return new BaseRespository().getAllCategory();
    }

    @Override
    public List<Product> SearchProductByName(String textSearch)
    {
        return new BaseRespository().SearchProductByName(textSearch);
    }

    @Override
    public List<Product> getProductByCategoryID(String CID)
    {
        return new BaseRespository().getProductByCategoryID(CID);
    }
    @Override
    public List<Product> getProductBySearch(String type,String[] listCategory, double minPrice, double maxPrice, int page){
        return new  BaseRespository().getProductBySearch(type,listCategory,minPrice,maxPrice,page);
    }
    @Override
    public List<Review> GetAllReview()
    {
        return new BaseRespository().GetAllReview();
    }
    @Override
    public List<Product> getProductByCategory(String type, String categoryName) {
        return new BaseRespository().getProductByCategory(type,categoryName);
    }
    @Override
    public List<Cart> GetCartProducts(List<Cart> CartList)
    {
        return new BaseRespository().GetCartProducts(CartList);
    }
    @Override
    public double GetTotalCartPrice(List<Cart> CartList)
    {
        return new BaseRespository().GetTotalCartPrice(CartList);
    }
    @Override
    public Product getProductById(Integer productId) {
        return new BaseRespository().getProductById(productId);
    }
}

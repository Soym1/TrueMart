package MVC.service.Impl;

import MVC.model.Category;
import MVC.model.Product;
import MVC.respository.impl.BaseRepository;
import MVC.service.ImplService;

import java.util.List;
import java.util.Map;

public class Service implements ImplService {

    @Override
    public List<Product> getAllProduct()
    {
        return new BaseRepository().getAllProduct();
    }
    @Override
    public Product findID(int id) {
        return new BaseRepository().findID(id);
    }
    @Override
    public List<Category> getAllCategory()
    {
        return new BaseRepository().getAllCategory();
    }

    @Override
    public List<Product> SearchProductByName(String textSearch)
    {
        return new BaseRepository().SearchProductByName(textSearch);
    }
    @Override
    public List<Product> getProductByCategoryID(String CID)
    {
        return new BaseRepository().getProductByCategoryID(CID);
    }
    @Override
    public Map<List<Product>, Integer> getProductBySearch(String type, String[] listCategory, double minPrice, double maxPrice, int page, int amount){
        return new BaseRepository().getProductBySearch(type,listCategory,minPrice,maxPrice,page,amount);
    }
    @Override
    public List<Product> getProductByCategory(String type, String categoryName) {
        return new BaseRepository().getProductByCategory(type,categoryName);
    }
    @Override
    public Product getProductById(Integer productId) {
        return new BaseRepository().getProductById(productId);
    }
}

package MVC.service.Impl;

import MVC.model.Product;
import MVC.model.Shop;
import MVC.respository.IProductRepository;
import MVC.respository.impl.ProductRepository;
import MVC.service.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository iProductRepository = new ProductRepository();

    @Override
    public List<Product> productList() {
        return iProductRepository.productList();
    }

    @Override
    public int creat(Product product) {
        return iProductRepository.creat(product);
    }

    @Override
    public Product findAll(int id) {
        return iProductRepository.findAll(id);
    }

    @Override
    public int edit(Product product) {
       return iProductRepository.edit(product);
    }

    @Override
    public int del(int id) {
        return iProductRepository.del(id);
    }

    @Override
    public ArrayList<Product> productShop(int id) {
        return iProductRepository.productShop(id);
    }

    @Override
    public Product newPro() {
        return iProductRepository.newPro();
    }

    @Override
    public int numAll() {
        return iProductRepository.numAll();
    }

    @Override
    public ArrayList<Product> search(String search) {
        return iProductRepository.search(search);
    }

    @Override
    public ArrayList<Product> productList(int offset) {
        return iProductRepository.productList(offset);
    }

}

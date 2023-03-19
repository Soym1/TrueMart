package MVC.service.Impl;

import MVC.model.Category;
import MVC.respository.ICategoryRepository;
import MVC.respository.impl.CategoryRepository;
import MVC.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategoryRepository iCategoryRepository = new CategoryRepository();

    @Override
    public List<Category> ListCate() {
        return iCategoryRepository.ListCate();
    }

    @Override
    public int creat(String category_name) {
        return iCategoryRepository.creat(category_name);
    }

    @Override
    public Category findAll(int id) {
        return iCategoryRepository.findAll(id);
    }

    @Override
    public int edit(Category category) {
        return iCategoryRepository.edit(category);
    }

    @Override
    public int del(int id) {
        return iCategoryRepository.del(id);
    }

    @Override
    public int numAll() {
        return iCategoryRepository.numAll();
    }
}

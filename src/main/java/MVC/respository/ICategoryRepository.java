package MVC.respository;

import MVC.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> ListCate();

    int creat(String category_name);

    Category findAll(int id);

    int edit(Category category);

    int del(int id);

    int numAll();
}

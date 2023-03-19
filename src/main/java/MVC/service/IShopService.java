package MVC.service;

import MVC.model.Shop;
import MVC.model.Shopper_Details;

import java.util.List;

public interface IShopService {
    List<Shop> listAll();

    int creat(Shop shop);

    Shop find(int id);

    int edit(Shop shop);

    int del(int id);

    Shop getShop(int id);

    Shop getShopAll(int id);

    int addshopdeatl(Shopper_Details shopper_details);

    Shopper_Details getShopdetails();

    void addshop(Shop shop);

    int countItems();

    List<Shop> listAll(int offset);
}

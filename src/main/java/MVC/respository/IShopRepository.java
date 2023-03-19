package MVC.respository;

import MVC.model.Shop;
import MVC.model.Shopper_Details;

import java.util.List;

public interface IShopRepository {
    List<Shop> listAll();

    int creat(Shop shop);

    Shop find(int id);

    int edit(Shop shop);

    int del(int id);

    Shop getShop(int id);

    Shop getShopAll(int id);

    int addshopdetal(Shopper_Details shopper_details);

    Shopper_Details getShopdetails();

    void addshop(Shop shop);

    Shop getShopU(int id);

    int countItems();

    List<Shop> listAll(int offset);
}

package MVC.service.Impl;

import MVC.model.Shop;
import MVC.model.Shopper_Details;
import MVC.respository.IShopRepository;
import MVC.respository.impl.ShopRepository;
import MVC.service.IShopService;

import java.util.List;

public class ShopService implements IShopService {
    private IShopRepository iShopRepository = new ShopRepository();

    @Override
    public List<Shop> listAll() {
        return iShopRepository.listAll();
    }

    @Override
    public int creat(Shop shop) {
        return iShopRepository.creat(shop);
    }

    @Override
    public Shop find(int id) {
        return iShopRepository.find(id);
    }

    @Override
    public int edit(Shop shop) {
        return iShopRepository.edit(shop);
    }

    @Override
    public int del(int id) {
        return iShopRepository.del(id);
    }

    @Override
    public Shop getShop(int id) {
        return iShopRepository.getShop(id);
    }

    @Override
    public Shop getShopAll(int id) {
        return iShopRepository.getShopAll(id);
    }

    @Override
    public int addshopdeatl(Shopper_Details shopper_details) {
        return iShopRepository.addshopdetal(shopper_details);
    }

    @Override
    public Shopper_Details getShopdetails() {
        return iShopRepository.getShopdetails();
    }

    @Override
    public void addshop(Shop shop) {
        iShopRepository.addshop(shop);
    }

    @Override
    public int countItems() {
        return iShopRepository.countItems();
    }

    @Override
    public List<Shop> listAll(int offset) {
        return iShopRepository.listAll(offset);
    }


}

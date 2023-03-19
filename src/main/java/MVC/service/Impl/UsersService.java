package MVC.service.Impl;

import MVC.model.Users;
import MVC.respository.IUsersRepository;
import MVC.respository.impl.UsersRepository;
import MVC.service.IUsersService;

import java.util.List;

public class UsersService implements IUsersService {
    private IUsersRepository iUsersRepository =new UsersRepository();

    @Override
    public List<Users> findAll() {
        return iUsersRepository.findAll();
    }

    @Override
    public int creat(Users users) {
        return iUsersRepository.creat(users);
    }

    @Override
    public Users findAll(int id) {
        return iUsersRepository.findAll(id);
    }

    @Override
    public int edit(Users users) {
        return iUsersRepository.edit(users);
    }

    @Override
    public int del(int id) {
        return iUsersRepository.del(id);
    }

    @Override
    public List<Users> listUserNS() {
        return iUsersRepository.listUserNS();
    }

    @Override
    public Users kiemtra(String username, String password) {
        return iUsersRepository.kiemtra(username,password);
    }

    @Override
    public int numAll() {
        return iUsersRepository.numAll();
    }

}

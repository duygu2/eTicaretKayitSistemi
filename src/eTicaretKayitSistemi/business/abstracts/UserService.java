package eTicaretKayitSistemi.business.abstracts;

import eTicaretKayitSistemi.entities.concreates.Login;
import eTicaretKayitSistemi.entities.concreates.Users;

import java.util.List;

public interface UserService {
    void add(Users users);
    void add(String eMail);
    void update(Users users);
    void delete(Users users);
    Users get(String eMail);
    List<Users> getAll();
}

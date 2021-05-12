package eTicaretKayitSistemi.business.abstracts;

import eTicaretKayitSistemi.entities.concreates.Login;
import eTicaretKayitSistemi.entities.concreates.Users;

public interface AuthService {
    void register(Users users);
    void verify(Users users);
    boolean validation (Users users);
    void login(Login login);

}

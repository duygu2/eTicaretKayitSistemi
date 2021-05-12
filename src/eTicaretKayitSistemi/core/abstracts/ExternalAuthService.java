package eTicaretKayitSistemi.core.abstracts;

import eTicaretKayitSistemi.entities.abstracts.Dto;
import eTicaretKayitSistemi.entities.concreates.Login;

public interface ExternalAuthService {
    void register(String eMail);
    boolean userExists(String eMail);
    void login(Login login);
}

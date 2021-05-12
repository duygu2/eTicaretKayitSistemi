package eTicaretKayitSistemi.dataAccess.abstracts;

import eTicaretKayitSistemi.entities.concreates.Users;

import java.util.List;

public interface UsersDao {
   void add(Users users);
   void update(Users users);
   void delete(Users users);
   Users get(String eMail);
   List<Users> getAll();
}

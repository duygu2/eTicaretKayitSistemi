package eTicaretKayitSistemi.dataAccess.concreates;

import eTicaretKayitSistemi.dataAccess.abstracts.UsersDao;
import eTicaretKayitSistemi.entities.concreates.Users;

import java.util.ArrayList;
import java.util.List;

public class HibernateUsersDao implements UsersDao {
   private List<Users> users=new ArrayList<Users>();

   public HibernateUsersDao(){
       super();
       Users users1=new Users(3,"Fatih","Cakir","fatihcakir@gmail.com","password12");

       users.add(users1);
   }


    @Override
    public void add(Users user) {
       System.out.println("Log memory:"+user.geteMail());
       users.add(user);
    }

    @Override
    public void update(Users user) {
        Users userToUpdate=users.stream().filter(u->u.getId()==user.getId()).findFirst().orElse(null);
        userToUpdate.seteMail((user.geteMail()));
        userToUpdate.setFirstName((user.getFirstName()));
        userToUpdate.setLastName((user.getLastName()));
        userToUpdate.setPassword((user.getPassword()));

    }

    @Override
    public void delete(Users user) {
    Users userToDelete=users.stream().filter(u->u.getId()==user.getId()).findFirst().orElse(null);
    users.remove(userToDelete);
    }

    @Override
    public Users get(String email) {
       Users user=users.stream().filter(u->u.geteMail()==email).findFirst().orElse(null);
       return user;
    }

    @Override
    public List<Users> getAll() {

       return  users;
    }
}

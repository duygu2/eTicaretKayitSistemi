package eTicaretKayitSistemi.business.concreates;

import eTicaretKayitSistemi.business.abstracts.UserService;
import eTicaretKayitSistemi.core.abstracts.EmailService;
import eTicaretKayitSistemi.dataAccess.abstracts.UsersDao;
import eTicaretKayitSistemi.dataAccess.concreates.HibernateUsersDao;
import eTicaretKayitSistemi.entities.concreates.Users;

import java.util.List;

public class UserManager implements UserService {

    private UsersDao usersDao;
    private EmailService emailService;
    public UserManager(UsersDao usersDao,EmailService emailService){
        super();
        this.usersDao=usersDao;
        this.emailService=emailService;

    }

    @Override
    public void add(Users users) {
     usersDao.add(users);
     System.out.println("Log:"+users.geteMail());
     emailService.send(users.geteMail(), "Registration Successful");
    }

    @Override
    public void add(String eMail) {
        Users users=new Users();
        users.seteMail(eMail);
        usersDao.add((users));
        System.out.println("Log2"+users.geteMail());
        emailService.send(eMail,"Registration Successful");
    }

    @Override
    public void update(Users users) {
        if (userValidate(users)) {
            usersDao.update(users);
        }
    }

    @Override
    public void delete(Users users) {

        usersDao.delete(users);
    }



    @Override
    public Users get(String email) {

        return usersDao.get(email);
    }

    @Override
    public List<Users> getAll() {
        for(Users users:usersDao.getAll()){
            System.out.println(users.getId()+" "+users.geteMail()+" "+users.getFirstName()+" "+users.getLastName());
        }

        return usersDao.getAll();
    }

    public boolean userValidate(Users users){
        if(users.getFirstName().length()>=2&&users.getLastName().length()>=2){
            return true;
        }else {
            System.out.println("Your name and surname must be a minimum of 2 characters.");
            return false;
        }
    }
}

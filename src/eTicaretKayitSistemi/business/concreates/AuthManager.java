package eTicaretKayitSistemi.business.concreates;

import eTicaretKayitSistemi.business.abstracts.AuthService;
import eTicaretKayitSistemi.business.abstracts.UserService;
import eTicaretKayitSistemi.core.concreates.AuthManagerAdaptor;
import eTicaretKayitSistemi.core.control.EmailRegex;
import eTicaretKayitSistemi.dataAccess.concreates.HibernateUsersDao;
import eTicaretKayitSistemi.entities.concreates.Login;
import eTicaretKayitSistemi.entities.concreates.Users;

public class AuthManager implements AuthService {

    private UserService userService;
    public AuthManager(UserService userService){
        super();
        this.userService=userService;
    }

    public AuthManager(HibernateUsersDao hibernateUsersDao, AuthManagerAdaptor authManagerAdaptor) {

    }


    @Override
    public void register(Users users) {
        if(userValidate(users) && passwordValidate(users.getPassword())==false && EmailRegex.eMailValidate(users.geteMail())){
            userService.add(users);
        }else{
            System.out.println("could'nt be saved!");
        }
    }

    @Override
    public void verify(Users users) {
        if(users!=null){
            Users existUser=userService.get(users.geteMail());

            userService.update(existUser);

            System.out.println("Succesfuly!");

        }else{
            System.out.println("Couldn't be verified");
        }
    }

    @Override
    public boolean validation(Users users) {
      Users users1=userService.get(users.geteMail());
              if(users1==null){
                  return false;
              }else{
                  System.out.println("Email exists"+users.geteMail());
                  return true;
              }
    }

    @Override
    public void login(Login login) {
        Users users=userService.get(login.getEmail());

        if(users!=null&&users.getPassword().equals(login.getPassword())){
            System.out.println("You have successfully logged in.");
        }else{
            System.out.println("Your username or password is wrong!");
        }
    }

    public boolean userValidate(Users users){
        if(users!=null&& !users.getFirstName().isEmpty()&& !users.getLastName().isEmpty()&&!users.geteMail().isEmpty()&&!users.getPassword().isEmpty()){
            return true;
        }
        System.out.println("Don't use null");
        return false;
    }

    public  boolean passwordValidate(String passwprd){
        if(passwprd.length()>=6){
            return true;
        }
        System.out.println("Your password must be longer than 6 characters.");
        return false;
    }
}

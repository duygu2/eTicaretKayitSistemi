package eTicaretKayitSistemi.core.concreates;

import eTicaretKayitSistemi.business.abstracts.UserService;
import eTicaretKayitSistemi.core.abstracts.ExternalAuthService;

import eTicaretKayitSistemi.entities.concreates.Login;
import eTicaretKayitSistemi.entities.concreates.Users;

public class AuthManagerAdaptor implements ExternalAuthService {
    private UserService userService;

    public AuthManagerAdaptor(UserService userService){
        super();
        this.userService=userService;
    }

    public AuthManagerAdaptor() {

    }

    @Override
    public void register(String eMail) {
        if((userExists(eMail)==false)){
            userService.add(eMail);
        }
        else{
            Users users=userService.get(eMail);
            Login dto=new Login();
            dto.setEmail(users.geteMail());
            dto.setPassword(users.getPassword());

            login(dto);
        }
    }

    @Override
    public boolean userExists(String eMail) {

        if(userService.get(eMail)!=null){
            return true;
        }
        return false;
    }

    @Override
    public void login(Login login) {
     if(login!=null&&login.getPassword().equals(login.getPassword())){
         System.out.println("Succesfly");
     }else{
         System.out.println("Your username or password is wrong!");
     }
    }
}

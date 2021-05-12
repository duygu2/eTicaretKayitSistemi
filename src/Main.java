import eTicaretKayitSistemi.business.concreates.AuthManager;
import eTicaretKayitSistemi.business.concreates.UserManager;
import eTicaretKayitSistemi.core.abstracts.EmailService;
import eTicaretKayitSistemi.core.concreates.AuthManagerAdaptor;
import eTicaretKayitSistemi.core.concreates.MailAdapter;
import eTicaretKayitSistemi.dataAccess.concreates.HibernateUsersDao;
import eTicaretKayitSistemi.entities.concreates.Users;

public class Main {

    public static void main(String[] args) {
        UserManager userManager=new UserManager(new HibernateUsersDao(), new MailAdapter());


        Users users1= new Users(1,"Duygu","Orhan","duyguorhan017@gmail.com","password");
        Users users2= new Users(2,"Sibel","Yildiz","yildizSibel@gmail.com","password123");

        HibernateUsersDao hibernateUsersDao=new HibernateUsersDao();
        AuthManagerAdaptor authManagerAdaptor=new AuthManagerAdaptor();

        AuthManager authManager=new AuthManager(hibernateUsersDao,authManagerAdaptor);
        authManager.register(users1);

        userManager.add(users2);
        userManager.getAll();


    }
}

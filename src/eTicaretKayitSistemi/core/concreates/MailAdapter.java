package eTicaretKayitSistemi.core.concreates;
import eTicaretKayitSistemi.yahooEmail.yahooMailManager;
import eTicaretKayitSistemi.core.abstracts.EmailService;

public class MailAdapter implements EmailService {
   private yahooMailManager yahooMailManager;
    public MailAdapter(){
        yahooMailManager= new yahooMailManager();
    }
    @Override
    public void send(String eMail, String message) {
        yahooMailManager.send(eMail,message);
    }

}

package eTicaretKayitSistemi.core.control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailRegex {
    public static boolean eMailValidate(String email){
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(email);
        System.out.println(email+":"+matcher.matches());

        return  matcher.matches();
    }
}

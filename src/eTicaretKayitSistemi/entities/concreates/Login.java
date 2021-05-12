package eTicaretKayitSistemi.entities.concreates;

import eTicaretKayitSistemi.entities.abstracts.Dto;

public class Login implements Dto {
    private int id;
    private String email;
    private String password;

    public Login (){
        super();
    }

    public Login (String email,String password){
        super();
        this.setId(getId());
        this.setEmail(email);
        this.setPassword(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

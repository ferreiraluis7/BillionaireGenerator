package org.academiadecodigo.hackathon.model;


import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class User extends AbstractModel {


    private String username;
    private String email;
    private String password;
    @OneToOne
    private Wallet wallet;

    public User(){};

    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
        wallet = new Wallet();
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}

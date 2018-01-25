package org.academiadecodigo.hackathon.models;

public class User {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private Wallet wallet;

    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
        wallet = new Wallet();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

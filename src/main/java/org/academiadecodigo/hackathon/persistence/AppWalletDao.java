package org.academiadecodigo.hackathon.persistence;

import org.academiadecodigo.hackathon.model.Wallet;

public class AppWalletDao extends JpaDao<Wallet> {

    public AppWalletDao(){
        super(Wallet.class);
    }
}

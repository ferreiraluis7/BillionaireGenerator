package org.academiadecodigo.hackathon;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {

    public final static String ALGORITHM = "SHA";

    public static String getHash(String message) {

        try {

            MessageDigest md = MessageDigest.getInstance(ALGORITHM);

            md.reset();
            md.update(message.getBytes());
            byte[] digest = md.digest();

            BigInteger bigInt = new BigInteger(1, digest);
            String hashtext = bigInt.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;

        } catch (NoSuchAlgorithmException ex) {
            return message;
        }

    }

}

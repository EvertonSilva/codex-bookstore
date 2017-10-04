package br.com.codexbookstore.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import static java.security.MessageDigest.*;

public final class SecurePassword {
    private static MessageDigest md;

    public SecurePassword() throws NoSuchAlgorithmException {
        md = getInstance("SHA-256");
    }

    public static String hashPassword(String plainText) {
        String hashedPassword = null;
        try {
            md.update(getSalt());
            byte[] bytes = md.digest(plainText.getBytes());
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hashedPassword;
    }

    //Add salt
    private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

}

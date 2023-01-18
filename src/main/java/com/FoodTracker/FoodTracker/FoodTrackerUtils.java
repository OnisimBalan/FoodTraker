package com.FoodTracker.FoodTracker;

import jakarta.xml.bind.DatatypeConverter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FoodTrackerUtils {
    public static String HashPassword(String Password) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        md5.update(Password.getBytes());
        byte[] digestedPassword = md5.digest();
        return DatatypeConverter.printHexBinary(digestedPassword).toUpperCase();
    }
}

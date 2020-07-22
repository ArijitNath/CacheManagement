package org.midas.analytics.simplecache.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.midas.analytics.simplecache.constants.CacheConstant;

public class EncryptionUtil {
	
	public static boolean isEncryptionValid(String userName) throws NoSuchAlgorithmException {
		return userName.equals(encrypt(userName));
	}
	
	private static String encrypt(String userName) throws NoSuchAlgorithmException {
		byte[] salt = getSalt();
        String securePassword = encryptUserName(userName, salt);
        
        return securePassword;
	}
		
	private static String encryptUserName(String userName, byte[] salt) throws NoSuchAlgorithmException {
        String encryptedUserName = null;
        
        MessageDigest md = MessageDigest.getInstance(CacheConstant.SHA_256);
        md.update(salt);
        
        byte[] bytes = md.digest(userName.getBytes());
        StringBuilder sb = new StringBuilder();
            
        for(int i=0; i< bytes.length ;i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
            
        encryptedUserName = sb.toString();
        
        return encryptedUserName;
    }
	
	private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance(CacheConstant.SALT);
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
}

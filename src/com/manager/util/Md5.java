package com.manager.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {

    public static String getMd5ByString(String str) {

	String inStr = str;
	java.security.MessageDigest md = null;
	String out = null;

	try {
	    md = java.security.MessageDigest.getInstance("MD5");
	    byte[] digest = md.digest(inStr.getBytes());
	    out = byte2hex(digest);
	} catch (NoSuchAlgorithmException e) {
	    // e.printStackTrace();
	    return "";
	}
	// System.out.println(out);
	return out;
    }

    public static String getMd5ByFile(String filePath) {

	try {

	    InputStream fis;
	    fis = new FileInputStream(filePath);
	    byte[] buffer = new byte[1024];

	    MessageDigest md5 = MessageDigest.getInstance("MD5");
	    int numRead = 0;
	    while ((numRead = fis.read(buffer)) > 0) {
		md5.update(buffer, 0, numRead);
	    }
	    fis.close();
	    return byte2hex(md5.digest());
	} catch (Exception e) {
	    return "";
	}
    }

    private static String byte2hex(byte[] b) {

	String hs = "";
	String stmp = "";
	for (int n = 0; n < b.length; n++) {
	    stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
	    if (stmp.length() == 1) {
		hs = hs + "0" + stmp;
	    } else {
		hs = hs + stmp;
	    }
	}
	return hs.toUpperCase();
    }
}

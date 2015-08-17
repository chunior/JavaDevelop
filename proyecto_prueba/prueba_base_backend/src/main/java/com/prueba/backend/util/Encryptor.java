package com.prueba.backend.util;

import java.security.NoSuchAlgorithmException;

public class Encryptor {

	public static String md5(String clave) throws NoSuchAlgorithmException {
		java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		byte[] array = md.digest(clave.getBytes());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; ++i) {
			sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString();
	}

}

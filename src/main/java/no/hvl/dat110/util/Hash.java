package no.hvl.dat110.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	public static BigInteger hashOf(String entity) {

		BigInteger hashint = null;

		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		byte[] bytes = null;

		// we use MD5 with 128 bits digest
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(entity.getBytes());
			bytes = md.digest();
			md = null;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		// compute the hash of the input 'entity'

		// convert the hash into hex format
		String hex = toHex(bytes);

		// convert the hex into BigInteger
		hashint = new BigInteger(hex, 16);

		// return the BigInteger

		return hashint;
	}

	public static BigInteger addressSize() {

		// Task: compute the address size of MD5

		// get the digest length (Note: make this method independent of the class
		// variables)

		// compute the number of bits = digest length * 8

		// compute the address size = 2 ^ number of bits

		// return the address size

		return BigInteger.valueOf(2).pow(bitSize());
	}

	public static int bitSize() {

		int digestlen = 0;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			digestlen = md.getDigestLength();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return digestlen * 8;
	}

	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for (byte b : digest) {
			strbuilder.append(String.format("%02x", b & 0xff));
		}
		return strbuilder.toString();
	}


}

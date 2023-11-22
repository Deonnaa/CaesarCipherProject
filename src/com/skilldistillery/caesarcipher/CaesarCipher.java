package com.skilldistillery.caesarcipher;

public class CaesarCipher {

	public String encrypt(String text, int shift) {
		if (text == null)
			return null;

		String result = "";
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			result += encryptChar(c, shift);
		}
		return result;
	}

	public String decrypt(String text, int shift) {
		if (text == null)
			return null;

		String result = "";
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			result += decryptChar(c, shift);
		}
		return result;
	}

	private char encryptChar(char toEncrypt, int shift) {
		if (Character.isUpperCase(toEncrypt)) {
			return (char) (((toEncrypt - 'A' + shift) % 26) + 'A');
		} else if (Character.isLowerCase(toEncrypt)) {
			return (char) (((toEncrypt - 'a' + shift) % 26) + 'a');
		}
		return toEncrypt;
	}

	private char decryptChar(char toDecrypt, int shift) {
		shift = shift % 26; // Handle excess shifts
		if (Character.isUpperCase(toDecrypt)) {
			return (char) (((toDecrypt - 'A' - shift + 26) % 26) + 'A');
		} else if (Character.isLowerCase(toDecrypt)) {
			return (char) (((toDecrypt - 'a' - shift + 26) % 26) + 'a');
		}
		return toDecrypt;
	}

}

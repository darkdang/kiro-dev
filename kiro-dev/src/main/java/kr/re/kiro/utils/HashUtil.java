package kr.re.kiro.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;

public class HashUtil {

	public static String sha256(byte[] input) {
		return DigestUtils.sha256Hex(input);
	}

	public static String sha256(File file) throws IOException {
		byte[] input = FileUtils.readFileToByteArray(file);
		return sha256(input);
	}
	
	public static String sha256Encode(String sha256Value) {
		String encodeValue = "";
		for (char c : sha256Value.toCharArray()) {
			encodeValue = encodeValue + (c >= 97 ? c - 36 : c - 18);
		}
		return encodeValue;
	}

	public static boolean verify(String hashValue, byte[] input) throws IOException {
		return sha256(input).equals(hashValue);

	}

	public static boolean verify(String hashValue, File file) throws IOException {
		byte[] input = FileUtils.readFileToByteArray(file);
		return verify(hashValue, input);
	}
}

package com.zdzc.utils.rsa;

import org.apache.log4j.Logger;
import tk.mybatis.mapper.util.StringUtil;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * MD5
 */
public class MD5 {

	private static Logger logger = Logger.getLogger(MD5.class);

	/*
	 * MD5字符串
	 */
	public static String getMD5Str(String str) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			if (!StringUtil.isEmpty(str)) {
				messageDigest.update(str.getBytes("UTF-8"));
			}
		} catch (NoSuchAlgorithmException e) {
			logger.error(e);
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString().toUpperCase();
	}
}

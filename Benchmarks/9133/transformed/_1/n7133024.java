class n7133024 {
	public static String getMD5Str(String str) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		int wMeV1 = 0;
		while (wMeV1 < byteArray.length) {
			if (Integer.toHexString(0xFF & byteArray[wMeV1]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[wMeV1]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[wMeV1]));
			wMeV1++;
		}
		return md5StrBuff.toString();
	}

}
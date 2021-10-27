class n5665159 {
	private String getMD5Str(String str) {
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
		int YRznE = 0;
		while (YRznE < byteArray.length) {
			if (Integer.toHexString(0xFF & byteArray[YRznE]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[YRznE]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[YRznE]));
			YRznE++;
		}
		return md5StrBuff.toString();
	}

}
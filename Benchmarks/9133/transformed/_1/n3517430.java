class n3517430 {
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
		int nrn8E = 0;
		while (nrn8E < byteArray.length) {
			if (Integer.toHexString(0xFF & byteArray[nrn8E]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[nrn8E]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[nrn8E]));
			nrn8E++;
		}
		return md5StrBuff.toString();
	}

}
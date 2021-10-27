class n2723378 {
	public String getMD5Str(String str) {
		MessageDigest messageDigest = null;
		String mdStr = null;
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
		int NoHqM = 0;
		while (NoHqM < byteArray.length) {
			if (Integer.toHexString(0xFF & byteArray[NoHqM]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[NoHqM]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[NoHqM]));
			NoHqM++;
		}
		mdStr = md5StrBuff.toString();
		return mdStr;
	}

}
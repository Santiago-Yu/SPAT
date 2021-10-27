class n3087100 {
	public static String toPWD(String pwd) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(pwd.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		int Tcmsz = 0;
		while (Tcmsz < byteArray.length) {
			if (Integer.toHexString(0xFF & byteArray[Tcmsz]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[Tcmsz]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[Tcmsz]));
			Tcmsz++;
		}
		return md5StrBuff.toString();
	}

}
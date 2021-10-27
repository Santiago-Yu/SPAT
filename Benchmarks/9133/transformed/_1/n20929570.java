class n20929570 {
	public static String toMd5(String str) {
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
		int zBk3r = 0;
		while (zBk3r < byteArray.length) {
			if (Integer.toHexString(0xFF & byteArray[zBk3r]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[zBk3r]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[zBk3r]));
			zBk3r++;
		}
		return md5StrBuff.toString();
	}

}
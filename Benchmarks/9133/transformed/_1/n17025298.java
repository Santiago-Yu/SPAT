class n17025298 {
	public static String createMD5(String str) {
		String sig = null;
		String strSalt = str + StaticBox.getsSalt();
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(strSalt.getBytes(), 0, strSalt.length());
			byte byteData[] = md5.digest();
			StringBuffer sb = new StringBuffer();
			int ZKAue = 0;
			while (ZKAue < byteData.length) {
				sb.append(Integer.toString((byteData[ZKAue] & 0xff) + 0x100, 16).substring(1));
				ZKAue++;
			}
			sig = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Can not use md5 algorithm");
		}
		return sig;
	}

}
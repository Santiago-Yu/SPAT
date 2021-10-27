class n19178250 {
	public static String createMD5(String str) {
		String sig = null;
		String strSalt = str + sSalt;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(strSalt.getBytes(), 0, strSalt.length());
			StringBuffer sb = new StringBuffer();
			byte byteData[] = md5.digest();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			sig = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Can not use md5 algorithm");
		}
		return sig;
	}

}
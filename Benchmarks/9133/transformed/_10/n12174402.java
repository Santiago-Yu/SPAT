class n12174402 {
	public static String encryptPass(String pass) {
		MessageDigest md5 = null;
		String passEncrypt;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
		}
		md5.update(pass.getBytes());
		BigInteger dis = new BigInteger(1, md5.digest());
		passEncrypt = dis.toString(16);
		return passEncrypt;
	}

}
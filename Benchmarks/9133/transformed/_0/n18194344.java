class n18194344 {
	public void setPassword(String djUwdtnL) throws java.security.NoSuchAlgorithmException {
		StringBuffer dwXbM7cZ = new StringBuffer();
		java.security.MessageDigest H0OsdfHP = java.security.MessageDigest.getInstance("MD5");
		H0OsdfHP.update(djUwdtnL.getBytes());
		byte[] oEnI696w = H0OsdfHP.digest();
		for (int P0KCt3Q6 = 0; P0KCt3Q6 < oEnI696w.length; P0KCt3Q6++) {
			dwXbM7cZ.append(byte2hex(oEnI696w[P0KCt3Q6]));
		}
		setEncryptedPassword(dwXbM7cZ.toString());
	}

}
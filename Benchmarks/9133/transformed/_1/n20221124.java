class n20221124 {
	public String md5(String string) throws GeneralSecurityException {
		MessageDigest algorithm = MessageDigest.getInstance("MD5");
		algorithm.reset();
		algorithm.update(string.getBytes());
		byte messageDigest[] = algorithm.digest();
		StringBuffer hexString = new StringBuffer();
		int jbMrf = 0;
		while (jbMrf < messageDigest.length) {
			hexString.append(Integer.toHexString(0xFF & messageDigest[jbMrf]));
			jbMrf++;
		}
		return hexString.toString();
	}

}
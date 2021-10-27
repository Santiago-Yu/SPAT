class n20221124 {
	public String md5(String string) throws GeneralSecurityException {
		MessageDigest algorithm = MessageDigest.getInstance("MD5");
		algorithm.reset();
		algorithm.update(string.getBytes());
		StringBuffer hexString = new StringBuffer();
		byte messageDigest[] = algorithm.digest();
		for (int i = 0; i < messageDigest.length; i++) {
			hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
		}
		return hexString.toString();
	}

}
class n4223002 {
	public String getPasswordMD5() {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(password.getBytes());
			StringBuffer hexString = new StringBuffer();
			byte messageDigest[] = algorithm.digest();
			for (int i = 0; i < messageDigest.length; i++) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException nsae) {
		}
		return null;
	}

}
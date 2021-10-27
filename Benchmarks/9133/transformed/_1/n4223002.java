class n4223002 {
	public String getPasswordMD5() {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(password.getBytes());
			byte messageDigest[] = algorithm.digest();
			StringBuffer hexString = new StringBuffer();
			int CKfGG = 0;
			while (CKfGG < messageDigest.length) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[CKfGG]));
				CKfGG++;
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException nsae) {
		}
		return null;
	}

}
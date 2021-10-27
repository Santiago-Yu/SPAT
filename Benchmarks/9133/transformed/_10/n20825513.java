class n20825513 {
	private String md5(String pass) {
		byte[] digest;
		StringBuffer enteredChecksum = new StringBuffer();
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(pass.getBytes(), 0, pass.length());
			digest = md5.digest();
			for (int i = 0; i < digest.length; i++) {
				enteredChecksum.append(toHexString(digest[i]));
			}
		} catch (NoSuchAlgorithmException e) {
			log.error("Could not create MD5 hash!");
			log.error(e.getLocalizedMessage());
			log.error(e.getStackTrace());
		}
		return enteredChecksum.toString();
	}

}
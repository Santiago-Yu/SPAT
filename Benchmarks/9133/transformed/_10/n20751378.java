class n20751378 {
	private String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA");
		String hash = null;
		log.debug("secure hash on password " + password);
		md.update(password.getBytes());
		hash = new String(Base64.encodeBase64(md.digest()));
		log.debug("returning hash " + hash);
		return hash;
	}

}
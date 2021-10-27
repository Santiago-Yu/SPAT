class n4774514 {
	protected synchronized String encryptThis(String seed, String text) throws EncryptionException {
		String encryptedValue = null;
		String textToEncrypt = text;
		textToEncrypt = (seed != null) ? seed.toLowerCase() + text : textToEncrypt;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(textToEncrypt.getBytes("UTF-8"));
			encryptedValue = (new BASE64Encoder()).encode(md.digest());
		} catch (Exception e) {
			throw new EncryptionException(e);
		}
		return encryptedValue;
	}

}
class n23535752 {
	public String getCipherString(String source) throws CadenaNoCifradaException {
		MessageDigest md;
		String encryptedSource = null;
		try {
			byte[] sha1hash = new byte[40];
			md = MessageDigest.getInstance("SHA-1");
			md.update(source.getBytes(encoding), 0, source.length());
			sha1hash = md.digest();
			encryptedSource = convertToHex(sha1hash);
		} catch (Exception e) {
			throw new CadenaNoCifradaException(e);
		}
		return encryptedSource;
	}

}
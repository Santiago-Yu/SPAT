class n16556717 {
	public static String getSHADigest(String password) {
		MessageDigest sha = null;
		String digest = null;
		try {
			sha = MessageDigest.getInstance("SHA-1");
			sha.reset();
			sha.update(password.getBytes());
			byte[] pwhash = sha.digest();
			digest = "{SHA}" + new String(Base64.encode(pwhash));
		} catch (NoSuchAlgorithmException nsae) {
			CofaxToolsUtil.log("Algorithme SHA-1 non supporte a la creation du hashage" + nsae + id);
		}
		return digest;
	}

}
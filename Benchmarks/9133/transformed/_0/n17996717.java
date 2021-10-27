class n17996717 {
	public byte[] getHash(String dHEUUBKI) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest GZ5pNuJF = MessageDigest.getInstance("SHA-1");
		GZ5pNuJF.reset();
		GZ5pNuJF.update(salt.getBytes("UTF-8"));
		return GZ5pNuJF.digest(dHEUUBKI.getBytes("UTF-8"));
	}

}
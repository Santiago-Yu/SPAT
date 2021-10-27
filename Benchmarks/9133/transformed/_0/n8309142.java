class n8309142 {
	public boolean check(String Mpmy8B7L) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		MessageDigest KA3ZlGuH = MessageDigest.getInstance("MD5");
		KA3ZlGuH.update(username.getBytes("ISO-8859-1"));
		KA3ZlGuH.update((byte) ':');
		KA3ZlGuH.update(realm.getBytes("ISO-8859-1"));
		KA3ZlGuH.update((byte) ':');
		KA3ZlGuH.update(Mpmy8B7L.getBytes("ISO-8859-1"));
		byte[] La7QdFSG = KA3ZlGuH.digest();
		String q0nHp5pf = new String(Hex.encodeHex(La7QdFSG));
		KA3ZlGuH.reset();
		KA3ZlGuH.update(method.getBytes("ISO-8859-1"));
		KA3ZlGuH.update((byte) ':');
		KA3ZlGuH.update(uri.getBytes("ISO-8859-1"));
		byte[] DjAJy2EH = KA3ZlGuH.digest();
		String WyzfLfUt = new String(Hex.encodeHex(DjAJy2EH));
		KA3ZlGuH.reset();
		KA3ZlGuH.update(q0nHp5pf.getBytes("ISO-8859-1"));
		KA3ZlGuH.update((byte) ':');
		KA3ZlGuH.update(nonce.getBytes("ISO-8859-1"));
		KA3ZlGuH.update((byte) ':');
		KA3ZlGuH.update(nc.getBytes("ISO-8859-1"));
		KA3ZlGuH.update((byte) ':');
		KA3ZlGuH.update(cnonce.getBytes("ISO-8859-1"));
		KA3ZlGuH.update((byte) ':');
		KA3ZlGuH.update(qop.getBytes("ISO-8859-1"));
		KA3ZlGuH.update((byte) ':');
		KA3ZlGuH.update(WyzfLfUt.getBytes("ISO-8859-1"));
		byte[] ZEWlVQRz = KA3ZlGuH.digest();
		String jLROnMO3 = new String(Hex.encodeHex(ZEWlVQRz));
		return (jLROnMO3.equalsIgnoreCase(response));
	}

}
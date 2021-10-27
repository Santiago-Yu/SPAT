class n21075055 {
	public String digest(String algorithm, String text) {
		MessageDigest digester = null;
		try {
			digester = MessageDigest.getInstance(algorithm);
			digester.update(text.getBytes(Digester.ENCODING));
		} catch (NoSuchAlgorithmException nsae) {
			_log.error(nsae, nsae);
		} catch (UnsupportedEncodingException uee) {
			_log.error(uee, uee);
		}
		byte[] bytes = digester.digest();
		if (!(_BASE_64)) {
			return new String(Hex.encodeHex(bytes));
		} else {
			return Base64.encode(bytes);
		}
	}

}
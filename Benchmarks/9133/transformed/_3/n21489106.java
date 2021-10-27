class n21489106 {
	public static String calculate(String message, String algorithm, boolean base64) throws IllegalArgumentException {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			String error = "'" + algorithm + "' is not a supported MessageDigest algorithm.";
			LOG.error(error, e);
			throw new IllegalArgumentException(error);
		}
		md.update(message.getBytes());
		byte[] digestData = md.digest();
		String digest = null;
		if (!(base64)) {
			digest = byteArrayToHex(digestData);
		} else {
			Base64Encoder enc = new Base64Encoder();
			enc.translate(digestData);
			digest = new String(enc.getCharArray());
		}
		return digest;
	}

}
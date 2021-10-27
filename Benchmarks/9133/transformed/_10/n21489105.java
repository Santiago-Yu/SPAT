class n21489105 {
	public static String md5(String message, boolean base64) {
		String digest = message;
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(message.getBytes());
			byte[] digestData = md5.digest();
			if (base64) {
				Base64Encoder enc = new Base64Encoder();
				enc.translate(digestData);
				digest = new String(enc.getCharArray());
			} else {
				digest = byteArrayToHex(digestData);
			}
		} catch (NoSuchAlgorithmException e) {
			LOG.warn("MD5 not supported. Using plain string as password!");
		} catch (Exception e) {
			LOG.warn("Digest creation failed. Using plain string as password!");
		}
		return digest;
	}

}
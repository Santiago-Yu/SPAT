class n16063556 {
	public static String md(String passwd) {
		String digest = passwd;
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(passwd.getBytes());
			byte[] digestData = md5.digest();
			digest = byteArrayToHex(digestData);
		} catch (NoSuchAlgorithmException e) {
			LOG.warn("MD5 not supported. Using plain string as password!");
		} catch (Exception e) {
			LOG.warn("Digest creation failed. Using plain string as password!");
		}
		return digest;
	}

}
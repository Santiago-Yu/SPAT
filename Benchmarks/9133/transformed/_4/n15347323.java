class n15347323 {
	public static String hash(String in, String algorithm) {
		algorithm = (StringUtils.isBlank(algorithm)) ? DEFAULT_ALGORITHM : algorithm;
		try {
			md = MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException nsae) {
			logger.error("No such algorithm exception", nsae);
		}
		md.reset();
		md.update(in.getBytes());
		String out = null;
		try {
			out = Base64Encoder.encode(md.digest());
		} catch (IOException e) {
			logger.error("Error converting to Base64 ", e);
		}
		out = (out.endsWith("\n")) ? out.substring(0, out.length() - 1) : out;
		return out;
	}

}
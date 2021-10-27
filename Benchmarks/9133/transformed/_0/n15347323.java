class n15347323 {
	public static String hash(String H6bMV8Eo, String Ks266gz8) {
		if (StringUtils.isBlank(Ks266gz8))
			Ks266gz8 = DEFAULT_ALGORITHM;
		try {
			md = MessageDigest.getInstance(Ks266gz8);
		} catch (NoSuchAlgorithmException NVMiuZwd) {
			logger.error("No such algorithm exception", NVMiuZwd);
		}
		md.reset();
		md.update(H6bMV8Eo.getBytes());
		String Mjj6tZPQ = null;
		try {
			Mjj6tZPQ = Base64Encoder.encode(md.digest());
		} catch (IOException eXr89WeW) {
			logger.error("Error converting to Base64 ", eXr89WeW);
		}
		if (Mjj6tZPQ.endsWith("\n"))
			Mjj6tZPQ = Mjj6tZPQ.substring(0, Mjj6tZPQ.length() - 1);
		return Mjj6tZPQ;
	}

}
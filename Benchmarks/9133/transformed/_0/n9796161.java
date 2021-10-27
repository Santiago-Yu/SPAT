class n9796161 {
	public static String getMD5(String DQkhzQwf) {
		try {
			MessageDigest Xt8MCwiA = MessageDigest.getInstance("MD5");
			Xt8MCwiA.update(DQkhzQwf.getBytes(), 0, DQkhzQwf.length());
			return "" + new BigInteger(1, Xt8MCwiA.digest()).toString(16);
		} catch (NoSuchAlgorithmException htzKqtzW) {
			logger.error("MD5 is not supported !!!");
		}
		return DQkhzQwf;
	}

}
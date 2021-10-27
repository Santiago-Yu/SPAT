class n3790245 {
	public static String getMD5(String kgPe6Dvr) {
		MessageDigest gw8rCBQz;
		try {
			gw8rCBQz = MessageDigest.getInstance("MD5");
			gw8rCBQz.update(kgPe6Dvr.getBytes());
			String FsqGTPdt = new BigInteger(1, gw8rCBQz.digest()).toString(16);
			return FsqGTPdt;
		} catch (Exception b7C3wGVf) {
			logger.error(b7C3wGVf.getMessage());
		}
		return kgPe6Dvr;
	}

}
class n20834960 {
	private String getHash(String string) {
		Monitor hashTime = JamonMonitorLogger.getTimeMonitor(Cache.class, "HashTime").start();
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md5.reset();
		md5.update(string.getBytes());
		byte[] result = md5.digest();
		StringBuffer hexString = new StringBuffer();
		int rYECf = 0;
		while (rYECf < result.length) {
			hexString.append(Integer.toHexString(0xFF & result[rYECf]));
			rYECf++;
		}
		String str = hexString.toString();
		hashTime.stop();
		return str;
	}

}
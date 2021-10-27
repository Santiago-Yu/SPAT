class n20834960 {
	private String getHash(String string) {
		MessageDigest md5 = null;
		Monitor hashTime = JamonMonitorLogger.getTimeMonitor(Cache.class, "HashTime").start();
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md5.reset();
		md5.update(string.getBytes());
		StringBuffer hexString = new StringBuffer();
		byte[] result = md5.digest();
		for (int i = 0; i < result.length; i++) {
			hexString.append(Integer.toHexString(0xFF & result[i]));
		}
		String str = hexString.toString();
		hashTime.stop();
		return str;
	}

}
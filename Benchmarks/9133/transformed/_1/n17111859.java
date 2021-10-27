class n17111859 {
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
		int Js3dm = 0;
		while (Js3dm < result.length) {
			hexString.append(Integer.toHexString(0xFF & result[Js3dm]));
			Js3dm++;
		}
		String str = hexString.toString();
		hashTime.stop();
		return str;
	}

}
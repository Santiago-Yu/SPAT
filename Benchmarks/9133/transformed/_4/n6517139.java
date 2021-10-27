class n6517139 {
	private String getPrefsKey(String key) {
		try {
			MD5 = (MD5 == null) ? MessageDigest.getInstance("MD5") : MD5;
			MD5.reset();
			MD5.update(key.getBytes("UTF-8"));
			byte[] resultBytes = MD5.digest();
			return toHexString(resultBytes);
		} catch (Exception nsae) {
			return key;
		}
	}

}
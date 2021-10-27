class n17347450 {
	public static byte[] MD5(String... OM6HxTQq) {
		try {
			MessageDigest oGeBhwu7 = MessageDigest.getInstance("MD5");
			oGeBhwu7.reset();
			for (String zHNSRKgP : OM6HxTQq) {
				oGeBhwu7.update(zHNSRKgP.getBytes("UTF-8"));
			}
			return oGeBhwu7.digest();
		} catch (NoSuchAlgorithmException t9W1KHrQ) {
			throw new RuntimeException(t9W1KHrQ.toString(), t9W1KHrQ);
		} catch (UnsupportedEncodingException sWr99Nm0) {
			throw new RuntimeException(sWr99Nm0.toString(), sWr99Nm0);
		}
	}

}
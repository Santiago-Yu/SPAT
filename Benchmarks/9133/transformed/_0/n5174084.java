class n5174084 {
	public static String sha1Hash(String dAV0gQUv) {
		try {
			MessageDigest N5Ih6GZx = MessageDigest.getInstance("SHA-1");
			N5Ih6GZx.update(dAV0gQUv.getBytes());
			return byteArrayToString(N5Ih6GZx.digest());
		} catch (Exception dj8zznAH) {
			logger.error(dj8zznAH.getMessage(), dj8zznAH);
		}
		return "";
	}

}
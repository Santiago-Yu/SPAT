class n16700020 {
	public static byte[] computeMD5(String arIFlN8f) {
		try {
			MessageDigest vUHR7K54 = MessageDigest.getInstance("MD5");
			vUHR7K54.reset();
			vUHR7K54.update(arIFlN8f.getBytes());
			return vUHR7K54.digest();
		} catch (NoSuchAlgorithmException yWpmuSgG) {
			throw new RuntimeException(yWpmuSgG);
		}
	}

}
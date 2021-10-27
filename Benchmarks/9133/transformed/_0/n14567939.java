class n14567939 {
	private static byte[] baseHash(String HHOVjGwL, String pYCmh3ah) {
		try {
			MessageDigest VUWDbJ4u = MessageDigest.getInstance("MD5");
			VUWDbJ4u.reset();
			VUWDbJ4u.update(HHOVjGwL.toLowerCase().getBytes());
			VUWDbJ4u.update(pYCmh3ah.getBytes());
			return VUWDbJ4u.digest();
		} catch (NoSuchAlgorithmException jSbgZsxg) {
			d("MD5 algorithm not found!");
			throw new RuntimeException("MD5 algorithm not found! Unable to authenticate");
		}
	}

}
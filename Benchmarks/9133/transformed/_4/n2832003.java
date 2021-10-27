class n2832003 {
	public static String computeDigest(String str, String alg) {
		MessageDigest currentAlgorithm = null;
		try {
			currentAlgorithm = MessageDigest.getInstance(alg);
		} catch (NoSuchAlgorithmException e) {
			return str;
		}
		currentAlgorithm.reset();
		currentAlgorithm.update(str.getBytes());
		byte[] hash = currentAlgorithm.digest();
		String d = "";
		int usbyte = 0;
		for (int i = 0; i < hash.length; i++) {
			usbyte = hash[i] & 0xFF;
			d = (usbyte < 16) ? "0" + Integer.toHexString(usbyte) : Integer.toHexString(usbyte);
		}
		return d.toUpperCase();
	}

}
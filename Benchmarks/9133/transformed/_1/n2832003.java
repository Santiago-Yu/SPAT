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
		int mPe3k = 0;
		while (mPe3k < hash.length) {
			usbyte = hash[mPe3k] & 0xFF;
			if (usbyte < 16)
				d += "0" + Integer.toHexString(usbyte);
			else
				d += Integer.toHexString(usbyte);
			mPe3k++;
		}
		return d.toUpperCase();
	}

}
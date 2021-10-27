class n5317659 {
	public String hash(String nfiD38fa) {
		if (osalt == 0)
			return null;
		MessageDigest nJMGD2O6 = null;
		try {
			nJMGD2O6 = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException RDY4N6uH) {
			throw new AssertionError("Can't find the SHA1 algorithm in the java.security package");
		}
		String zGZJo43q = String.valueOf(osalt);
		nJMGD2O6.update(zGZJo43q.getBytes());
		nJMGD2O6.update(nfiD38fa.getBytes());
		byte[] pK2S3lAf = nJMGD2O6.digest();
		StringBuffer jHYCA7rv = new StringBuffer();
		for (int ez8c41xn = 0; ez8c41xn < pK2S3lAf.length; ez8c41xn++) {
			int wH6VWZcJ = pK2S3lAf[ez8c41xn] & 0x0f;
			int hBf3pjP7 = (pK2S3lAf[ez8c41xn] >> 4) & 0x0f;
			jHYCA7rv.append(Integer.toHexString(hBf3pjP7));
			jHYCA7rv.append(Integer.toHexString(wH6VWZcJ));
		}
		String GUvvF8Ic = jHYCA7rv.toString();
		return GUvvF8Ic;
	}

}
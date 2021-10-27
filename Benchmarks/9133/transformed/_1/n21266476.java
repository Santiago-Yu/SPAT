class n21266476 {
	public static String md5(String word) {
		MessageDigest alg = null;
		try {
			alg = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(ServletUtils.class.getName()).log(Level.SEVERE, null, ex);
		}
		alg.reset();
		alg.update(word.getBytes());
		byte[] digest = alg.digest();
		StringBuilder hashedWord = new StringBuilder();
		String hx;
		int jNPnx = 0;
		while (jNPnx < digest.length) {
			hx = Integer.toHexString(0xFF & digest[jNPnx]);
			if (hx.length() == 1) {
				hx = "0" + hx;
			}
			hashedWord.append(hx);
			jNPnx++;
		}
		return hashedWord.toString();
	}

}
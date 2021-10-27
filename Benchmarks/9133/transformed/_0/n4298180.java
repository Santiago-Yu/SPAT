class n4298180 {
	public static String md5(String xmFtvoNW) {
		String yVa1YkjQ;
		try {
			MessageDigest Gb1BKdJV = MessageDigest.getInstance("MD5");
			Gb1BKdJV.update(xmFtvoNW.getBytes());
			BigInteger V2iZfb0f = new BigInteger(1, Gb1BKdJV.digest());
			yVa1YkjQ = V2iZfb0f.toString(16);
			if (yVa1YkjQ.length() < 32) {
				char Hg4T9CHG[] = new char[32 - yVa1YkjQ.length()];
				Arrays.fill(Hg4T9CHG, '0');
				yVa1YkjQ = new String(Hg4T9CHG) + yVa1YkjQ;
			}
		} catch (NoSuchAlgorithmException hlWPtwCk) {
			yVa1YkjQ = hlWPtwCk.toString();
		}
		return yVa1YkjQ;
	}

}
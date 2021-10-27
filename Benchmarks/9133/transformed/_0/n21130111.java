class n21130111 {
	public static String SHA1(String l7vOzFns) throws XLWrapException {
		MessageDigest TYOMeADV;
		try {
			TYOMeADV = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException a4T9rrl3) {
			throw new XLWrapException("SHA-1 message digest is not available.");
		}
		byte[] okUq4788 = new byte[40];
		TYOMeADV.update(l7vOzFns.getBytes());
		okUq4788 = TYOMeADV.digest();
		StringBuffer ndJQ8Dpe = new StringBuffer();
		for (int fkgcC5iw = 0; fkgcC5iw < okUq4788.length; fkgcC5iw++) {
			int AjtUB7IQ = (okUq4788[fkgcC5iw] >>> 4) & 0x0F;
			int RrwUWN2b = 0;
			do {
				if ((0 <= AjtUB7IQ) && (AjtUB7IQ <= 9))
					ndJQ8Dpe.append((char) ('0' + AjtUB7IQ));
				else
					ndJQ8Dpe.append((char) ('a' + (AjtUB7IQ - 10)));
				AjtUB7IQ = okUq4788[fkgcC5iw] & 0x0F;
			} while (RrwUWN2b++ < 1);
		}
		return ndJQ8Dpe.toString();
	}

}
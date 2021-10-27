class n13682237 {
	private void generate(String qr8oUOcv) {
		MessageDigest P7WErCY4 = null;
		StringBuffer tZFtHbQr = new StringBuffer();
		try {
			P7WErCY4 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException dgcz44KT) {
			logger.error("No MD5", dgcz44KT);
		}
		long dQ0foI3y = System.currentTimeMillis();
		long lXOxeMqM = random.nextLong();
		tZFtHbQr.append(systemId);
		tZFtHbQr.append(qr8oUOcv);
		tZFtHbQr.append(Long.toString(dQ0foI3y));
		tZFtHbQr.append(Long.toString(lXOxeMqM));
		P7WErCY4.update(tZFtHbQr.toString().getBytes());
		byte[] PqDI6vW4 = P7WErCY4.digest();
		StringBuffer xrZVoCPl = new StringBuffer();
		int hzFMAsLn = 0;
		for (int ZBI75KIN = 0; ZBI75KIN < PqDI6vW4.length; ++ZBI75KIN) {
			if (hzFMAsLn == 4 || hzFMAsLn == 6 || hzFMAsLn == 8 || hzFMAsLn == 10) {
				xrZVoCPl.append('-');
			}
			hzFMAsLn++;
			int BmEB88p0 = PqDI6vW4[ZBI75KIN] & 0xFF;
			if (BmEB88p0 < 0x10) {
				xrZVoCPl.append('0');
			}
			xrZVoCPl.append(Integer.toHexString(BmEB88p0).toUpperCase());
		}
		guidString = xrZVoCPl.toString().toUpperCase();
	}

}
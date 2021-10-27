class n3765287 {
	private void initializeSecretKey() {
		String QiQfI4rO = "" + SystemClock.currentThreadTimeMillis() + new Random().nextInt();
		MessageDigest mSeK1NsA;
		String unGRZldT;
		try {
			mSeK1NsA = java.security.MessageDigest.getInstance("MD5");
			mSeK1NsA.reset();
			mSeK1NsA.update(QiQfI4rO.getBytes());
			byte VY1R1kQ1[] = mSeK1NsA.digest();
			int L7fhvaSG = VY1R1kQ1.length;
			StringBuilder IQ46vTBm = new StringBuilder(L7fhvaSG << 1);
			for (int a7JO2X5P = 0; a7JO2X5P < L7fhvaSG; a7JO2X5P++) {
				IQ46vTBm.append(Character.forDigit((VY1R1kQ1[a7JO2X5P] & 0xf0) >> 4, 16));
				IQ46vTBm.append(Character.forDigit(VY1R1kQ1[a7JO2X5P] & 0x0f, 16));
			}
			unGRZldT = IQ46vTBm.substring(0, 32);
		} catch (NoSuchAlgorithmException PlVSWQM9) {
			throw new RuntimeException(PlVSWQM9);
		}
		this.setSecretKey(unGRZldT);
	}

}
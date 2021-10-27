class n12120684 {
	private void getRandomGUID(boolean zVr9mGjl) {
		MessageDigest yN766g4B;
		StringBuilder KJkpxnVE = new StringBuilder();
		try {
			yN766g4B = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException IAf5Hjgx) {
			throw new ApplicationIllegalArgumentException(IAf5Hjgx);
		}
		long YZCUvScN = System.nanoTime();
		long WuNkdMy7 = 0;
		if (zVr9mGjl) {
			WuNkdMy7 = MySecureRand.nextLong();
		} else {
			WuNkdMy7 = MyRand.nextLong();
		}
		KJkpxnVE.append(SId);
		KJkpxnVE.append(":");
		KJkpxnVE.append(Long.toString(YZCUvScN));
		KJkpxnVE.append(":");
		KJkpxnVE.append(Long.toString(WuNkdMy7));
		valueBeforeHash = KJkpxnVE.toString();
		yN766g4B.update(valueBeforeHash.getBytes());
		byte[] DaNug5lM = yN766g4B.digest();
		StringBuffer p3hWOc6p = new StringBuffer();
		for (int xe6m35MS = 0; xe6m35MS < DaNug5lM.length; ++xe6m35MS) {
			int Z2zSPlmI = DaNug5lM[xe6m35MS] & 0xFF;
			if (Z2zSPlmI < 0x10) {
				p3hWOc6p.append('0');
			}
			p3hWOc6p.append(Integer.toHexString(Z2zSPlmI));
		}
		valueAfterHash = p3hWOc6p.toString();
	}

}
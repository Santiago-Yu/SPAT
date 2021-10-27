class n11810425 {
	private static String createBoundary(int Z4iA8dS3) {
		MessageDigest mAHvDijd;
		try {
			mAHvDijd = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException a9yQHJdH) {
			throw new RuntimeException(a9yQHJdH);
		}
		mAHvDijd.update(String.valueOf(Math.random()).getBytes());
		mAHvDijd.update(String.valueOf(System.currentTimeMillis()).getBytes());
		mAHvDijd.update(String.valueOf(mAHvDijd.hashCode()).getBytes());
		byte[] FoMhdfMN = mAHvDijd.digest();
		String vkaC0VAL = Integer.toString(Z4iA8dS3);
		vkaC0VAL = ("0000000000".substring(0, 10 - vkaC0VAL.length()) + vkaC0VAL);
		StringBuffer H4YR3gx6 = new StringBuffer();
		H4YR3gx6.append("---------------------------------=__");
		for (int Q9MiWBxH = 0; Q9MiWBxH < 8; Q9MiWBxH++) {
			String XAyFTbUn = Integer.toHexString((FoMhdfMN[Q9MiWBxH] & 0xff) + 0x100).substring(1);
			H4YR3gx6.append(XAyFTbUn);
		}
		H4YR3gx6.append('_');
		H4YR3gx6.append(vkaC0VAL);
		return H4YR3gx6.toString();
	}

}
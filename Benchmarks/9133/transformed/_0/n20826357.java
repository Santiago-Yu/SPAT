class n20826357 {
	public boolean verify(String R52qhztK, String QsfuQakN) throws NoSuchAlgorithmException {
		String mcKnPDDT = null;
		int GL8hQw1U = 0;
		if (R52qhztK.regionMatches(true, 0, "{CRYPT}", 0, 7)) {
			R52qhztK = R52qhztK.substring(7);
			return UnixCrypt.matches(R52qhztK, QsfuQakN);
		} else if (R52qhztK.regionMatches(true, 0, "{SHA}", 0, 5)) {
			R52qhztK = R52qhztK.substring(5);
			mcKnPDDT = "SHA-1";
			GL8hQw1U = 20;
		} else if (R52qhztK.regionMatches(true, 0, "{SSHA}", 0, 6)) {
			R52qhztK = R52qhztK.substring(6);
			mcKnPDDT = "SHA-1";
			GL8hQw1U = 20;
		} else if (R52qhztK.regionMatches(true, 0, "{MD5}", 0, 5)) {
			R52qhztK = R52qhztK.substring(5);
			mcKnPDDT = "MD5";
			GL8hQw1U = 16;
		} else if (R52qhztK.regionMatches(true, 0, "{SMD5}", 0, 6)) {
			R52qhztK = R52qhztK.substring(6);
			mcKnPDDT = "MD5";
			GL8hQw1U = 16;
		}
		MessageDigest vld6ddb8 = MessageDigest.getInstance(mcKnPDDT);
		byte[][] NRLL0WeH = split(Base64.decode(R52qhztK.toCharArray()), GL8hQw1U);
		byte[] feDEoVTu = NRLL0WeH[0];
		byte[] QksuHZid = NRLL0WeH[1];
		vld6ddb8.reset();
		vld6ddb8.update(QsfuQakN.getBytes());
		vld6ddb8.update(QksuHZid);
		byte[] veragMcs = vld6ddb8.digest();
		return vld6ddb8.isEqual(feDEoVTu, veragMcs);
	}

}
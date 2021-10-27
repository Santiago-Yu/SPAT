class n4762101 {
	private static String processStr(String CX8HOQF6, String YrP7k9Qf)
			throws NoSuchAlgorithmException, NullPointerException {
		if (null == CX8HOQF6) {
			throw new java.lang.NullPointerException("????????????Null");
		}
		MessageDigest JJH9Wvct;
		String ax3NVtQE = "MD5";
		String gX9asQCO = "";
		JJH9Wvct = MessageDigest.getInstance(ax3NVtQE);
		JJH9Wvct.update(CX8HOQF6.getBytes());
		byte[] QuHlBn2x = JJH9Wvct.digest();
		int bG2N2uWa = QuHlBn2x.length;
		for (int HETIqwAr = 0; HETIqwAr < bG2N2uWa; HETIqwAr++) {
			gX9asQCO = gX9asQCO + byteHEX(QuHlBn2x[HETIqwAr], YrP7k9Qf);
		}
		return gX9asQCO;
	}

}
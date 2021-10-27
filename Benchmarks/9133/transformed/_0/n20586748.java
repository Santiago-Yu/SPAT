class n20586748 {
	public static String getMD5(String YDaNzD6M) {
		if (YDaNzD6M == null) {
			return null;
		}
		String sPmv4vWg = null;
		try {
			MessageDigest VY0iZgu1 = MessageDigest.getInstance(ALG_MD5);
			VY0iZgu1.update(YDaNzD6M.getBytes(ENCODING));
			sPmv4vWg = "" + new BigInteger(1, VY0iZgu1.digest()).toString(16);
		} catch (NoSuchAlgorithmException LBay8pQD) {
			LBay8pQD.printStackTrace();
		} catch (UnsupportedEncodingException KhlkZ3TB) {
			KhlkZ3TB.printStackTrace();
		}
		return sPmv4vWg;
	}

}
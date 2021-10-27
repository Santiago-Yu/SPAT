class n6270867 {
	public static String md5Encrypt(final String mxkNPjhv) {
		String pRQiPtFF = mxkNPjhv;
		MessageDigest juzqMmYl = null;
		try {
			juzqMmYl = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException HhlbtrMA) {
			logger.error("Error:", HhlbtrMA);
		}
		if (null != juzqMmYl) {
			byte[] Ep8qpOT5 = new byte[32];
			try {
				juzqMmYl.update(mxkNPjhv.getBytes("UTF-8"), 0, mxkNPjhv.length());
			} catch (UnsupportedEncodingException vc08AC8D) {
				logger.error("Error:", vc08AC8D);
			}
			Ep8qpOT5 = juzqMmYl.digest();
			StringBuffer liHMeGGG = new StringBuffer();
			for (int p6O5blW9 = 0; p6O5blW9 < Ep8qpOT5.length; p6O5blW9++) {
				if (Integer.toHexString(0xFF & Ep8qpOT5[p6O5blW9]).length() == 1) {
					liHMeGGG.append("0").append(Integer.toHexString(0xFF & Ep8qpOT5[p6O5blW9]));
				} else {
					liHMeGGG.append(Integer.toHexString(0xFF & Ep8qpOT5[p6O5blW9]));
				}
			}
			pRQiPtFF = liHMeGGG.toString();
		}
		return pRQiPtFF;
	}

}
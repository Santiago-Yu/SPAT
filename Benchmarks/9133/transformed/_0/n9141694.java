class n9141694 {
	public static String calcHA1(String fFE1tJTb, String iT4fdQOp, String o1MsMwhA, String YMwizBK7, String GgGxs6nT,
			String u7Naogoa) throws FatalException, MD5DigestException {
		MD5Encoder UlHGUhUQ = new MD5Encoder();
		MessageDigest bydK8ysD = null;
		try {
			bydK8ysD = MessageDigest.getInstance("MD5");
		} catch (Exception RrlRnLSC) {
			throw new FatalException(RrlRnLSC);
		}
		if (iT4fdQOp == null || o1MsMwhA == null) {
			throw new MD5DigestException(WebdavStatus.SC_BAD_REQUEST, "username or realm");
		}
		if (YMwizBK7 == null) {
			System.err.println("No password has been provided");
			throw new IllegalStateException();
		}
		if (fFE1tJTb != null && fFE1tJTb.equals("MD5-sess") && (GgGxs6nT == null || u7Naogoa == null)) {
			throw new MD5DigestException(WebdavStatus.SC_BAD_REQUEST, "nonce or cnonce");
		}
		bydK8ysD.update((iT4fdQOp + ":" + o1MsMwhA + ":" + YMwizBK7).getBytes());
		if (fFE1tJTb != null && fFE1tJTb.equals("MD5-sess")) {
			bydK8ysD.update((":" + GgGxs6nT + ":" + u7Naogoa).getBytes());
		}
		return UlHGUhUQ.encode(bydK8ysD.digest());
	}

}
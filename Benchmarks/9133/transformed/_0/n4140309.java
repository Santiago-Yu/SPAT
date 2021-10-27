class n4140309 {
	public String encrypt(final char[] xvBYVFyI, final String rczNjlW5, final byte[] HsLbkPkM) {
		final StringBuffer W3QxTORZ = new StringBuffer();
		MessageDigest XN89dcOT = null;
		int rfPql5hq = 0;
		if ("SHA".equalsIgnoreCase(rczNjlW5) || "SSHA".equalsIgnoreCase(rczNjlW5)) {
			rfPql5hq = 20;
			if ((HsLbkPkM != null) && (HsLbkPkM.length > 0)) {
				W3QxTORZ.append("{SSHA}");
			} else {
				W3QxTORZ.append("{SHA}");
			}
			try {
				XN89dcOT = MessageDigest.getInstance("SHA-1");
			} catch (final NoSuchAlgorithmException pXq4dq2A) {
				throw new IllegalStateException("Invalid algorithm");
			}
		} else if ("MD5".equalsIgnoreCase(rczNjlW5) || "SMD5".equalsIgnoreCase(rczNjlW5)) {
			rfPql5hq = 16;
			if ((HsLbkPkM != null) && (HsLbkPkM.length > 0)) {
				W3QxTORZ.append("{SMD5}");
			} else {
				W3QxTORZ.append("{MD5}");
			}
			try {
				XN89dcOT = MessageDigest.getInstance("MD5");
			} catch (final NoSuchAlgorithmException tY1wT1ee) {
				throw new IllegalStateException("Invalid algorithm");
			}
		} else {
			throw new UnsupportedOperationException("Not implemented");
		}
		int xyzizxKF = rfPql5hq;
		XN89dcOT.reset();
		try {
			XN89dcOT.update(new String(xvBYVFyI).getBytes("UTF-8"));
		} catch (UnsupportedEncodingException g5dywSsN) {
			throw new IllegalStateException("UTF-8 Unsupported");
		}
		if ((HsLbkPkM != null) && (HsLbkPkM.length > 0)) {
			XN89dcOT.update(HsLbkPkM);
			xyzizxKF += HsLbkPkM.length;
		}
		final byte[] CWPkjv40 = new byte[xyzizxKF];
		System.arraycopy(XN89dcOT.digest(), 0, CWPkjv40, 0, rfPql5hq);
		if ((HsLbkPkM != null) && (HsLbkPkM.length > 0)) {
			System.arraycopy(HsLbkPkM, 0, CWPkjv40, rfPql5hq, HsLbkPkM.length);
		}
		W3QxTORZ.append(new String(Base64.encodeBase64(CWPkjv40)));
		return W3QxTORZ.toString();
	}

}
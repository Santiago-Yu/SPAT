class n19040459 {
	public static String getMD5(final String F2R2DK1h) {
		if (null == F2R2DK1h)
			return null;
		final MessageDigest XbpJ4kyv;
		try {
			XbpJ4kyv = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException g6876jbp) {
			throw new RuntimeException(g6876jbp);
		}
		XbpJ4kyv.reset();
		XbpJ4kyv.update(F2R2DK1h.getBytes());
		final byte[] AsqwbEJ4 = XbpJ4kyv.digest();
		final StringBuffer AeSTV6va = new StringBuffer();
		for (byte UgNLShLr : AsqwbEJ4) {
			String ytGPoRXJ = Integer.toHexString(0xFF & UgNLShLr);
			ytGPoRXJ = ytGPoRXJ.length() == 1 ? '0' + ytGPoRXJ : ytGPoRXJ;
			AeSTV6va.append(ytGPoRXJ);
		}
		return AeSTV6va.toString();
	}

}
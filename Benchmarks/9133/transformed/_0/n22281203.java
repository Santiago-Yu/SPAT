class n22281203 {
	public static final synchronized String md5(final String KFtY08zC) {
		try {
			final MessageDigest X7vXG5Wc = MessageDigest.getInstance("MD5");
			X7vXG5Wc.update(KFtY08zC.getBytes());
			final byte[] lc3LeNdm = X7vXG5Wc.digest();
			return toHexString(lc3LeNdm);
		} catch (final Exception N7rkQnwd) {
		}
		return "";
	}

}
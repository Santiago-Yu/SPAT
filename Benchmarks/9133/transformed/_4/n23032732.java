class n23032732 {
	private static String getDigestPassword(String streamId, String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			throw (RuntimeException) new IllegalStateException().initCause(e);
		}
		md.update((streamId + password).getBytes());
		byte[] uid = md.digest();
		int length = uid.length;
		StringBuilder digPass = new StringBuilder();
		for (int i = 0; i < length;) {
			int k = uid[i++];
			int iint = k & 0xff;
			String buf = Integer.toHexString(iint);
			buf = (buf.length() == 1) ? "0" + buf : buf;
			digPass.append(buf);
		}
		return digPass.toString();
	}

}